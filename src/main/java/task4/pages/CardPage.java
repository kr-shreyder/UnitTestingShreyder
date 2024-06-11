package task4.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardPage extends BasePage {

    private static final Logger logger = Logger.getLogger(DebetPage.class);

    @FindBy(xpath = "//h1//p")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@id, 'form')]")
    private WebElement cardForm;

    @FindBy(xpath = "//h5")
    private WebElement nameForm;

    @FindBy(xpath = "//div[contains(@class, 'kbmNqrR8B')]")
    private List<WebElement> typeCardList;

    @FindBy(xpath = "//div[contains(@data-qa-type, 'deposit/premiumCardPrice.title')]")
    private WebElement nameTypeText;

    @Step("Проверка открытия страницы 'Карта Black Premium'")
    public CardPage checkOpenPage() {
        waitUntilElementToBeVisible(title);
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Премиальный уровень с картой Black Premium",
                title.getText());
        logger.info("Проверка открытия страницы");
        return this;
    }

    @Step("Скролл до формы оформления карты")
    public CardPage scrollToCardForm() {
        scrollToElementJs(cardForm);
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Выберите вид карты",
                nameForm.getText());
        logger.info("На странице показана форма оформления карты");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Проверка отображения названия в правой части после клика по типу карты '{nameType}'")
    public CardPage clickOnTypeCard(String nameType) {
        for (WebElement card : typeCardList) {
            if (card.findElement(By.xpath("./picture/img")).getAttribute("alt").equals(nameType)) {
                card.click();
                logger.info("Нажатие на тип карты " + nameType);
                Assert.assertEquals("После нажатия в правой части написан неправильный тип", nameType, nameTypeText.getText());
                return this;
            }
        }
        Assert.fail("Нет типа с названием " + nameType);
        return this;
    }
}
