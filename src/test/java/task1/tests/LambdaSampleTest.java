package task1.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import task1.pages.*;
import task1.tests.base.BaseTest;

public class LambdaSampleTest extends BaseTest {

    @Test
    @DisplayName("Тестирование списка дел 'LambdaTest Sample App'")
    public void test(){
        StartPage startPage  = new StartPage();
        startPage.checkText()
                .checkItem("First Item")
                .checkboxByName("First Item")
                .checkItem("Second Item")
                .checkboxByName("Second Item")
                .checkItem("Third Item")
                .checkboxByName("Third Item")
                .checkItem("Fourth Item")
                .checkboxByName("Fourth Item")
                .checkItem("Fifth Item")
                .checkboxByName("Fifth Item")
                .addNewItem("Sixth Item")
                .checkboxByName("Sixth Item");
    }
}