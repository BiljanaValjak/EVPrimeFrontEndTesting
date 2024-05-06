package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.*;

public class EventsPageTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private CreateNewUserLoginPage loginPage;
    private SingleEventPage singleEventPage;


    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        singleEventPage = new SingleEventPage(driver);

        sidePanel.navigateTo("http://localhost:3000/");
        sidePanel.clickMenuIcon();
        Thread.sleep(3000);
        sidePanel.clickLoginLink();

        String email = "testmail" + dateBuilder.currentTime() + "@mail.com";
        String password = "testpassword";

        loginPage.insertEmail(email);
        loginPage.insertPassword(password);

        loginPage.clickChangingButton();
        loginPage.clickGoButton();

        sidePanel.clickLoginLink();
        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        Thread.sleep(5000);
        loginPage.clickGoButton();
        Thread.sleep(5000);

        sidePanel.clickEventsLink();

    }

    @Test
    public void eventsDisplayedTest() throws InterruptedException {
        Thread.sleep(3000);
        eventsPage.eventsListPageDisplayed();

        assertEquals(eventsPage.getEventText(0), eventsPage.listOfEvents(0));
        Thread.sleep(5000);
        eventsPage.clickOnEvent(1);

        assertEquals("http://localhost:3000/events",singleEventPage.hrefFromBackToEventsButton());
        singleEventPage.clickBackToEventsButton();
        assertTrue(eventsPage.eventsListPageDisplayed());

    }

    @Test
    public void hoverOverPlusButton(){
        eventsPage.hoverOverPlusButton();
        eventsPage.clickAddEventButton();
        sidePanel.clickHomeLink();

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
