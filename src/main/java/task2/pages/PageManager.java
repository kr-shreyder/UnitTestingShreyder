package task2.pages;

public class PageManager {

    private static PageManager INSTANCE = null;
    private HomePage startPage;
    private SchedulePage schedulePage;
    private ScheduleGroupPage scheduleGroupPage;

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

    public SchedulePage getSchedulePage() {
        if (schedulePage == null) {
            schedulePage = new SchedulePage();
        }
        return schedulePage;
    }

    public ScheduleGroupPage getScheduleGroupPage() {
        if (scheduleGroupPage == null) {
            scheduleGroupPage = new ScheduleGroupPage();
        }
        return scheduleGroupPage;
    }

}