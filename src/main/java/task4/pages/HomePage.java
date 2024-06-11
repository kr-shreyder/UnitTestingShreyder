package task4.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    private static final Logger logger = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//meta[@property='og:url']")
    private WebElement linkHomePage;

    @FindBy(xpath = "//span[contains(@data-test, 'menu-item')]")
    private List<WebElement> sectionItemList;

    @FindBy(xpath = "//div[contains(@data-test, 'text-item')]")
    private List<WebElement> menuItemList;

    @Step("Проверка открытия главной страницы")
    public HomePage checkOpenPage() {
        Assert.assertTrue("Страница не открылась", linkHomePage.getAttribute("content").contains("https://www.tbank.ru"));
        logger.info("Открыта главная страница");
        return this;
    }

    @Step("Навести на пункт меню '{sectionMenuItem}'")
    public HomePage cursorOnMenuItem(String sectionMenuItem) {
        for (WebElement section : sectionItemList) {
            if (section.getText().equalsIgnoreCase(sectionMenuItem)) {
                waitUntilElementToBeVisible(section);
                moveToElement(section);
                logger.info("Навести на пункт меню " + sectionMenuItem);
                return this;
            }
        }
        Assert.fail("Не пункта меню с названием " + sectionMenuItem);
        return this;
    }

    @Step("Клик по подпункту меню '{menuItem}'")
    public DebetPage clickOnMenuItemDebet(String menuItem) {
        for (WebElement item : menuItemList) {
            if (item.findElement(By.xpath("./following-sibling::span[1]")).getText().equals(menuItem)) {
                item.click();
                logger.info("Переход на страницу " + menuItem);
                return pageManager.getDebetPage();
            }
        }
        Assert.fail("Нет подпункта меню с названием " + menuItem);
        return pageManager.getDebetPage();
    }

    @Step("Клик по подпункту меню '{menuItem}'")
    public AviaPage clickOnMenuItemAvia(String menuItem) {
        for (WebElement item : menuItemList) {
            if (item.findElement(By.xpath("./following-sibling::span[1]")).getText().equals(menuItem)) {
                waitUntilElementToBeVisible(item);
                item.click();
                logger.info("Переход на страницу " + menuItem);
                return pageManager.getAviaPage();
            }
        }
        Assert.fail("Нет подпункта меню с названием " + menuItem);
        return pageManager.getAviaPage();
    }

    @Step("Клик по подпункту меню '{menuItem}'")
    public HelpPage clickOnMenuItemHelp(String menuItem) {
        for (WebElement item : menuItemList) {
            if (item.findElement(By.xpath("./following-sibling::span[1]")).getText().equals(menuItem)) {
                waitUntilElementToBeVisible(item);
                item.click();
                logger.info("Переход на страницу " + menuItem);
                return pageManager.getHelpPage();
            }
        }
        Assert.fail("Нет подпункта меню с названием " + menuItem);
        return pageManager.getHelpPage();
    }
}
