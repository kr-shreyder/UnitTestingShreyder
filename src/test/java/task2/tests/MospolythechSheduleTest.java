package task2.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import task2.pages.HomePage;
import task2.tests.base.BaseTest;

public class MospolythechSheduleTest extends BaseTest {
    @Test
    @DisplayName("Тестирование страницы расписания на сайте Мосполитеха")
    public void test(){
        HomePage startPage  = new HomePage();
        startPage.checkOpenPage().
                clickOnHamburgerMenu()
                .mouseOnMenuItem("Обучающимся")
                .clickOnMenuItem("Расписания")
                .checkOpenPage()
                .clickOnButton()
                .checkOpenPage()
                .inputGroupNumber("221-361")
                .clickOnGroup("221-361");
    }
}
