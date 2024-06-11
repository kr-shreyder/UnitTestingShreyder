package task4.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class HelpPage extends BasePage{
    private static final Logger logger = Logger.getLogger(AviaPage.class);

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@data-qa-type='uikit/dropdown.item']/span/span[2]")
    private List<WebElement> searchList;

    @Step("Проверка открытия страницы 'Т-помощь'")
    public HelpPage checkOpenPage() {
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Т‑Помощь",
                title.getText());
        logger.info("Проверка открытия страницы");
        return this;
    }

    @Step("Поиск слова '{searchQuery}'")
    public HelpPage searchAnswers(String searchQuery) {
        waitUntilElementToBeClickable(inputSearch).click();
        inputSearch.sendKeys(searchQuery);
        for (WebElement answer: searchList) {
            if (!answer.getText().toLowerCase().contains(searchQuery.toLowerCase())) {
                Assert.fail("Предложенный ответ " + answer.getText() +  "' не содержит '" + searchQuery + "'");
            }
        }
        logger.info("Поиск ответов по запросу " + searchQuery);
        return this;
    }
}
