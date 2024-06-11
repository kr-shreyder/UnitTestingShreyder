package task3.tests.base;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Cookie;
import managers.DriverManager;
import managers.InitManager;

import java.util.Date;

public class BaseTest {
    private final DriverManager driverManager = DriverManager.getInstance();

    @BeforeClass
    public static void beforeClass() {
        InitManager.initFramework();
    }

    @Before
    public void before() {
        driverManager.getDriver().get("https://market.yandex.ru/");
        driverManager.getDriver().manage().addCookie(new Cookie("spravka",
                "dD0xNjg2NTk1MzQ0O2k9NzkuMTA0LjcuMTk3O0Q9OTVDM0RFQzg5NjlDQzRERTk5RkNGRkMzMEFDN0FBQkE1QkNENEY4NUI3NTFERDNGRTA1N0MyQkI1M0U4ODAyNkUxQ0M3QUE5OTA4OTM5NTk7dT0xNjg2NTk1MzQ0OTgzNzk2NzAwO2g9NGUyZTg4ZWQ2ZGFkYjUwZDdjYjY1MWIxYWExNjlmYjM=",
                ".yandex.ru", "/", new Date(2024, 7, 11, 18, 56, 03)));
        driverManager.getDriver().get("https://market.yandex.ru/");

    }

    @AfterClass
    public static void after() {
        InitManager.quitFramework();
    }
}