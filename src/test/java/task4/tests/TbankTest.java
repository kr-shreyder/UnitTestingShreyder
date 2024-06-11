package task4.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import task4.pages.*;
import task4.tests.base.BaseTest;

public class TbankTest extends BaseTest {
    HomePage homePage = new HomePage();
    DebetPage debetPage = new DebetPage();
    CardPage cardPage = new CardPage();
    AviaPage aviaPage = new AviaPage();
    HelpPage helpPage = new HelpPage();

    @Test
    @DisplayName("Проверка смены типа карты при оформлении")
    public void testCase1() {
        homePage.checkOpenPage()
                .cursorOnMenuItem("Частным лицам")
                .clickOnMenuItemDebet("Дебетовые карты");
        debetPage.clickOnCategoryItem("Премиальные")
                .clickOnCardBlock("Премиальная карта Black Premium");
        cardPage.scrollToCardForm()
                .clickOnTypeCard("Металлическая карта");
    }

    @Test
    @DisplayName("Проверка календаря в поиске авиабилетов")
    public void testCase2() {
        homePage.checkOpenPage()
                .cursorOnMenuItem("Частным лицам")
                .clickOnMenuItemAvia("Авиабилеты");
        aviaPage.checkOpenPage()
                .changeTypeTicket("В одну сторону")
                .selectDate("01.07");
    }

    @Test
    @DisplayName("Проверка поиска на странице 'Т-помощь'")
    public void testCase3() {
        homePage.checkOpenPage()
                .cursorOnMenuItem("Еще")
                .clickOnMenuItemHelp("Вопросы по продуктам");
        helpPage.checkOpenPage()
                .searchAnswers("Кредит");
    }

}
