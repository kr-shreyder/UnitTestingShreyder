package task2.tests.base;

import managers.DriverManager;
import managers.InitManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTest {
    private final DriverManager driverManager = DriverManager.getInstance();

    @BeforeClass
    public static void beforeClass(){
        InitManager.initFramework();
    }

    @Before
    public void before(){
        driverManager.getDriver().get("https://mospolytech.ru/");
    }
    @AfterClass
    public static void after(){
        InitManager.quitFramework();
    }
}