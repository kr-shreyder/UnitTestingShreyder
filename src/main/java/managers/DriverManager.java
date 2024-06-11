package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropsConst;


public class DriverManager {
    private WebDriver driver;
    private final TestPropManager propManager = TestPropManager.getInstance();

    private static DriverManager instance = null;

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
    }
}
