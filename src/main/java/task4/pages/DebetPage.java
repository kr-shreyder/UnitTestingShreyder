package task4.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task4.pages.BasePage;

import java.util.List;

public class DebetPage extends BasePage {

    private static final Logger logger = Logger.getLogger(DebetPage.class);

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//span[contains(@class, 'abt1suM7')]")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//div[contains(@class, 'cb-+q3lGXM')]")
    private List<WebElement> cardNameList;

    @Step("Проверка открытия страницы 'Дебетовые карты'")
    public DebetPage checkOpenPage() {
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Дебетовые карты",
                title.getText());
        logger.info("Проверка открытия страницы");
        return this;
    }

    @Step("Выбрать на странице категорию '{categoryItem}'")
    public DebetPage clickOnCategoryItem(String categoryItem) {
        for (WebElement item : categoryList) {
            if (item.getText().equals(categoryItem)) {
                item.click();
                logger.info("Показаны только премиальные дебетовые карты");
                return this;
            }
        }
        Assert.fail("Категория с названием " + categoryItem + " не найдена");
        return this;
    }

    @Step("Клик по карте с названием '{cardName}'")
    public CardPage clickOnCardBlock(String cardName) {
        for (WebElement card : cardNameList) {
            if (card.findElement(By.xpath("./following-sibling::div[1]/div/h2/p")).getText().equals(cardName)) {
                card.click();
                logger.info("Переход на страницу карты " + cardName);
                return pageManager.getCardPage();
            }
        }
        Assert.fail("Нет карты с названием " + cardName);
        return pageManager.getCardPage();
    }
}