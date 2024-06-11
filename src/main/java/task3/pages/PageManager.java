package task3.pages;

public class PageManager {

    private static PageManager INSTANCE = null;
    private HomePage startPage;
    private LaptopPage laptopPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public HomePage getHomePage() {
        if (startPage == null) {
            startPage = new HomePage();
        }
        return startPage;
    }

    public LaptopPage getLaptopPage() {
        if (laptopPage == null) {
            laptopPage = new LaptopPage();
        }
        return laptopPage;
    }
}