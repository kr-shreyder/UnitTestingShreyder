package task3.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import task3.pages.HomePage;
import task3.tests.base.BaseTest;

public class YandexMarketTest extends BaseTest {

    @Test
    @DisplayName("Тестирование Яндекс.Маркета. 7 вариант. Проверка фильтра по уцененным товарам")
    public void test() {
        HomePage startPage = new HomePage();
        startPage.checkOpenPage()
                .clickOnCatalog()
                .moveToCategory("Ноутбуки и компьютеры")
                .clickOnMenuItem("Ноутбуки")
                .logProducts()
                .setDiscount();
    }
}