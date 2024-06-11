package task4.pages;

public class PageManager {

    private static PageManager INSTANCE = null;
    private HomePage homePage;
    private DebetPage debetPage;
    private CardPage cardPage;
    private AviaPage aviaPage;
    private HelpPage helpPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public DebetPage getDebetPage() {
        if (debetPage == null) {
            debetPage = new DebetPage();
        }
        return debetPage;
    }

    public CardPage getCardPage() {
        if (cardPage == null) {
            cardPage = new CardPage();
        }
        return cardPage;
    }

    public AviaPage getAviaPage() {
        if (aviaPage == null) {
            aviaPage = new AviaPage();
        }
        return aviaPage;
    }

    public HelpPage getHelpPage() {
        if (helpPage == null) {
            helpPage = new HelpPage();
        }
        return helpPage;
    }
}