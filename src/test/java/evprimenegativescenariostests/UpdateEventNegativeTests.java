package evprimenegativescenariostests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateEventNegativeTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private CreateNewUserLoginPage loginPage;
    private AddNewEventPage addNewEventPage;
    private UpdateEventPage updateEventPage;
    private SingleEventPage singleEventPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        addNewEventPage = new AddNewEventPage(driver);
        updateEventPage = new UpdateEventPage(driver);
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
        Thread.sleep(3000);

        sidePanel.clickLoginLink();
        Thread.sleep(3000);

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        Thread.sleep(3000);
        loginPage.clickGoButton();
        Thread.sleep(3000);

        sidePanel.clickEventsLink();
        Thread.sleep(5000);
        eventsPage.clickOnEvent(0);
        Thread.sleep(5000);
        singleEventPage.clickEditEventButton();
    }

    @Test
    public void unsuccessfulPostEmptyTitleTest() throws InterruptedException {
        updateEventPage.clearTitle();
        Thread.sleep(3000);

        updateEventPage.clickUpdateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(updateEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",updateEventPage.errorPageTitle());
    }

    @Test
    public void unsuccessfulPostEmptyImageTest() throws InterruptedException {
        updateEventPage.clearImage();
        Thread.sleep(3000);

        updateEventPage.clickUpdateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(updateEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",updateEventPage.errorPageTitle());
    }

    @Test
    public void unsuccessfulPostEmptyDateTest() throws InterruptedException {
        Thread.sleep(5000);
        updateEventPage.clearDate();

        Thread.sleep(3000);

        updateEventPage.clickUpdateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(updateEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",updateEventPage.errorPageTitle());
    }

    @Test
    public void unsuccessfulPostEmptyLocationTest() throws InterruptedException {
        updateEventPage.clearLocation();
        Thread.sleep(3000);

        updateEventPage.clickUpdateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(updateEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",updateEventPage.errorPageTitle());
    }

    @Test
    public void unsuccessfulPostEmptyDescriptionTest() throws InterruptedException {
        updateEventPage.clearDescription();
        Thread.sleep(3000);

        updateEventPage.clickUpdateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(updateEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",updateEventPage.errorPageTitle());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

