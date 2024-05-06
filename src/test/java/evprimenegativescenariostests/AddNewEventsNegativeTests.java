package evprimenegativescenariostests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddNewEventsNegativeTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private CreateNewUserLoginPage loginPage;
    private AddNewEventPage addNewEventPage;

    String title = RandomStringUtils.randomAlphanumeric(15);
    String image = "https://europebookings.com/wp-content/uploads/we-are-festival-stage-lights-show.jpg";
    String date = dateBuilder.currentDate();
    String location = RandomStringUtils.randomAlphanumeric(15);
    String description = RandomStringUtils.randomAlphanumeric(50);


    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        addNewEventPage = new AddNewEventPage(driver);

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

        eventsPage.hoverOverPlusButton();
        eventsPage.clickAddEventButton();

    }

    @Test
    public void unsuccessfulPostEmptyTitleTest(){
        addNewEventPage.insertEventTitle("");
        addNewEventPage.insertEventImage(image);
        addNewEventPage.insertEventDate(date);
        addNewEventPage.insertEventLocation(location);
        addNewEventPage.insertEventDescription(description);

        addNewEventPage.clickCreateEventButton();
        assertEquals("http://localhost:3000/events/new", addNewEventPage.getUrlFromPage());
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @Test
    public void unsuccessfulPostEmptyImageTest(){
        addNewEventPage.insertEventTitle(title);
        addNewEventPage.insertEventImage("");
        addNewEventPage.insertEventDate(date);
        addNewEventPage.insertEventLocation(location);
        addNewEventPage.insertEventDescription(description);

        addNewEventPage.clickCreateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @Test
    public void unsuccessfulPostInvalidImageFormatTest(){
        addNewEventPage.insertEventTitle(title);
        addNewEventPage.insertEventImage("europebookings.com/wp-content/uploads/we-are-festival-stage-lights-show.jpg");
        addNewEventPage.insertEventDate(date);
        addNewEventPage.insertEventLocation(location);
        addNewEventPage.insertEventDescription(description);

        addNewEventPage.clickCreateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @Test
    public void unsuccessfulPostEmptyDateTest(){
        addNewEventPage.insertEventTitle(title);
        addNewEventPage.insertEventImage(image);
        addNewEventPage.insertEventDate("");
        addNewEventPage.insertEventLocation(location);
        addNewEventPage.insertEventDescription(description);

        addNewEventPage.clickCreateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @Test
    public void unsuccessfulPostEmptyLocationTest(){
        addNewEventPage.insertEventTitle(title);
        addNewEventPage.insertEventImage(image);
        addNewEventPage.insertEventDate(date);
        addNewEventPage.insertEventLocation("");
        addNewEventPage.insertEventDescription(description);

        addNewEventPage.clickCreateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @Test
    public void unsuccessfulPostEmptyDescriptionTest(){
        addNewEventPage.insertEventTitle(title);
        addNewEventPage.insertEventImage(image);
        addNewEventPage.insertEventDate(date);
        addNewEventPage.insertEventLocation(location);
        addNewEventPage.insertEventDescription("");

        addNewEventPage.clickCreateEventButton();
        addNewEventPage.getUrlFromPage();
        assertTrue(addNewEventPage.errorPageDisplayed());
        assertEquals("Unexpected Application Error!",addNewEventPage.errorPageTitle());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
