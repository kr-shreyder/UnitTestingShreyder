package task1.tests.base;

import managers.DriverManager;
import managers.InitManager;
import org.junit.*;

public class BaseTest {
    private final DriverManager driverManager = DriverManager.getInstance();

    @BeforeClass
    public static void beforeClass() {
        InitManager.initFramework();
    }

    @Before
    public void before() {
        driverManager.getDriver().get("https://lambdatest.github.io/sample-todo-app/");
    }

    @AfterClass
    public static void after() {
        InitManager.quitFramework();
    }
}