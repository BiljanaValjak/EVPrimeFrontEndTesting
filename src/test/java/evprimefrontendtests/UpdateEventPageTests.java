package evprimefrontendtests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;

public class UpdateEventPageTests {

    private WebDriver driver;
    DateBuilder dateBuilder = new DateBuilder();
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private SingleEventPage singleEventPage;
    private CreateNewUserLoginPage loginPage;
    private UpdateEventPage updateEventPage;
    private AddNewEventPage addNewEventPage;
    private DeleteEventPage deleteEventPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        singleEventPage = new SingleEventPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        updateEventPage = new UpdateEventPage(driver);
        addNewEventPage = new AddNewEventPage(driver);
        deleteEventPage = new DeleteEventPage(driver);

        sidePanel.navigateTo("http://localhost:3000/");
        sidePanel.clickMenuIcon();
        Thread.sleep(5000);
        sidePanel.clickLoginLink();

        String email = "testmail" + dateBuilder.currentTime() + "@mail.com";
        String password = "testpassword";

        loginPage.insertEmail(email);
        loginPage.insertPassword(password);

        loginPage.clickChangingButton();
        loginPage.clickGoButton();
        Thread.sleep(5000);

        sidePanel.clickLoginLink();

       loginPage.insertEmailLogIn(email);
       loginPage.insertPasswordLogIn(password);

        Thread.sleep(5000);
        loginPage.clickGoButton();
        Thread.sleep(3000);
        sidePanel.clickEventsLink();

        Thread.sleep(3000);
        eventsPage.hoverOverPlusButton();
        eventsPage.clickAddEventButton();

        addNewEventPage.insertEventTitle(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs4r1eo4XSe9I2FooO8qxCSKk4C-IraXUOHg&s");
        addNewEventPage.insertEventDate(dateBuilder.currentDate());
        addNewEventPage.insertEventLocation(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventDescription(RandomStringUtils.randomAlphanumeric(50));

        addNewEventPage.clickCreateEventButton();
        Thread.sleep(5000);
        eventsPage.lastEntry();
        Thread.sleep(5000);
        singleEventPage.clickEditEventButton();
    }

    @Test
    public void updateEventTest() throws InterruptedException {
        Thread.sleep(5000);
        updateEventPage.updateTitle( " - New title");
        updateEventPage.updateImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs4r1eo4XSe9I2FooO8qxCSKk4C-IraXUOHg&s");
        updateEventPage.updateDate(" - "  + dateBuilder.currentDate());
        updateEventPage.updateLocation( " - New Location");
        updateEventPage.updateDescription(" - New description");

        updateEventPage.clickUpdateEventButton();
        Thread.sleep(3000);
        singleEventPage.singleEventPageDisplayed();
        singleEventPage.clickDeleteButton();
        deleteEventPage.clickDeleteButtonPopUpMsg();
    }

    @Test
    public void updateEventButtonUserInterfaceTest(){
        updateEventPage.getTextFromUpdateEventButton();
        assertEquals("UPDATE EVENT", updateEventPage.getTextFromUpdateEventButton());
        assertEquals("0.875", updateEventPage.updateEventButtonFontSize());
        assertEquals("\"Josefin Sans\"", updateEventPage.updateEventButtonFontFamily());
        assertEquals("#2e7d32", updateEventPage.updateEventButtonBackGroundColor());

        sidePanel.clickEventsLink();
        eventsPage.lastEntry();
        singleEventPage.clickDeleteButton();
        deleteEventPage.clickDeleteButtonPopUpMsg();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
