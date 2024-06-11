package task4.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AviaPage extends BasePage {
    private static final Logger logger = Logger.getLogger(AviaPage.class);

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@data-qa-file, 'CalendarInputIcon')]")
    private WebElement calendar;

    @FindBy(xpath = "//button[contains(@data-qa-type, 'Tabs_not-active')]")
    private WebElement calendarContent;

    @FindBy(xpath = "//button[contains(@data-qa-type, 'Tabs_active')]")
    private WebElement selectedType;

    @FindBy(xpath = "//div[contains(@data-qa-file, 'CalendarMonth')][2]/table/tbody/tr/td/span/div/div/div")
    private List<WebElement> dateList;

    @FindBy(xpath = "//label[contains(@class, 'travelsearchform') and text()='Туда']/.././following-sibling::div")
    private WebElement label;

    @Step("Проверка открытия страницы 'Авиабилеты'")
    public AviaPage checkOpenPage() {
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Поиск дешевых авиабилетов",
                title.getText());
        logger.info("Проверка открытия страницы");
        return this;
    }

    @Step("Смена типа билетов на '{ticketTypeName}'")
    public AviaPage changeTypeTicket(String ticketTypeName) {
        calendar.click();
        waitUntilElementToBeVisible(calendarContent);
        calendarContent.click();
        Assert.assertEquals("Тип не сменен",
                ticketTypeName,
                selectedType.getText());
        logger.info("Смена типа билета на " + ticketTypeName);
        return this;
    }

    @Step("Проверка отображения даты после выбора в календаре")
    public AviaPage selectDate(String date) {
        for (WebElement num : dateList) {
            waitUntilElementToBeVisible(num);
            if (num.findElement(By.xpath("./following-sibling::div")).getAttribute("data-qa-date").equals(date)) {
                num.click();
                logger.info("Нажатие на дату " + date);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Assert.assertEquals("После нажатия дня в календаре отсутствует или стоит неверная дата", label.getText(), "1 июля, пн");
                return this;
            }
        }
        return this;
    }
}
