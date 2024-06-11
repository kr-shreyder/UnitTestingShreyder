package task2.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleGroupPage extends BasePage {

    private static final Logger logger = Logger.getLogger(ScheduleGroupPage.class);

    @FindBy(tagName = "h4")
    private WebElement title;

    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement inputGroup;

    @FindBy(xpath = "//div[contains(@class, 'found-groups')]/*")
    private List<WebElement> groupsList;

    @FindBy(xpath = "//div[contains(@class, 'schedule-day_today')]/div[contains(@class, 'title')]")
    private WebElement dayToday;

    @Step("Проверка открытия страницы 'Расписание занятий'")
    public ScheduleGroupPage checkOpenPage() {
        Assert.assertEquals("Заголовок отсутствует или не соответствует ожидаемому",
                "Расписание занятий",
                title.getText());
        logger.info("Проверка открытия страницы");
        return this;
    }

    @Step("Ввести группу {numOfGroup}")
    public ScheduleGroupPage inputGroupNumber(String numOfGroup) {
        waitUntilElementToBeClickable(inputGroup).click();
        inputGroup.sendKeys(numOfGroup);
        inputGroup.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("В результатах поиска отображается больше одной группы или вообще не отображается", 1, groupsList.size());
        Assert.assertEquals("В результатах поиска не отображается искомая группа", numOfGroup, findGroup(groupsList, numOfGroup));
        logger.info("Ввод группы " + numOfGroup);
        return this;
    }

    @Step("Нажать на найденную группу {numOfGroup}")
    public ScheduleGroupPage clickOnGroup(String numOfGroup) {
        for (WebElement group : groupsList) {
            if (group.getAttribute("id").equals(numOfGroup)) {
                group.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Assert.assertEquals("Не открылось расписание выбранной группы", "Расписание " + numOfGroup, driverManager.getDriver().getTitle());
                if (getCurrentDayOfWeek() != "Воскресенье") {
                    Assert.assertEquals("Текущий день недели не выделен цветом", getCurrentDayOfWeek(), dayToday.getText());
                }
                logger.info("Клик по найденной группе " + numOfGroup);
                return this;
            }
        }
        Assert.fail("Не найдена группу");
        return this;
    }
}