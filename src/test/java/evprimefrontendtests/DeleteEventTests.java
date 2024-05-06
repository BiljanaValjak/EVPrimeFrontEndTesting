package evprimefrontendtests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.*;

public class DeleteEventTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private CreateNewUserLoginPage loginPage;
    private SingleEventPage singleEventPage;
    private AddNewEventPage addNewEventPage;
    private DeleteEventPage deleteEvent;


    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        singleEventPage = new SingleEventPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        addNewEventPage = new AddNewEventPage(driver);
        deleteEvent = new DeleteEventPage(driver);

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

        Thread.sleep(5000);

        eventsPage.hoverOverPlusButton();
        eventsPage.clickAddEventButton();

        addNewEventPage.insertEventTitle(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs4r1eo4XSe9I2FooO8qxCSKk4C-IraXUOHg&s");
        addNewEventPage.insertEventDate(dateBuilder.currentDate());
        addNewEventPage.insertEventLocation(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventDescription(RandomStringUtils.randomAlphanumeric(50));

        addNewEventPage.clickCreateEventButton();
        Thread.sleep(2000);
        eventsPage.eventsListPageDisplayed();
        Thread.sleep(2000);
        sidePanel.clickCloseMenuButton();
        Thread.sleep(5000);

        eventsPage.lastEntry();

    }

    @Test
    public void deleteEventTest(){
        singleEventPage.clickDeleteButton();
        assertTrue(deleteEvent.deletePopUpDisplayed());
        deleteEvent.clickNoButton();
        singleEventPage.singleEventPageDisplayed();

        singleEventPage.clickDeleteButton();
        deleteEvent.clickDeleteButtonPopUpMsg();

    }

    @Test
    public void isEventPresentAfterDeletionTest() throws InterruptedException {
        String url = singleEventPage.getCurrentUrlFromPage();
        String id = url.substring(url.lastIndexOf("/")+1);
        System.out.println(id);
        Thread.sleep(5000);

        singleEventPage.clickDeleteButton();
        deleteEvent.clickDeleteButtonPopUpMsg();

        eventsPage.eventsListPageDisplayed();
        assertFalse(eventsPage.isEventPresents(id));

    }

    @Test
    public void deletePopUpMessageUserInterfaceTest(){
        singleEventPage.clickDeleteButton();
        assertEquals("Are you sure you want to delete this event?",deleteEvent.deleteMessageText());
        assertEquals("24px",deleteEvent.deleteMessageFontSize());
        assertEquals("\"Josefin Sans\"",deleteEvent.deleteMessageFontFamily());

        assertEquals("DELETE",deleteEvent.deleteButtonText());
        assertEquals("14px",deleteEvent.deleteButtonFontSize());
        assertEquals("\"Josefin Sans\"",deleteEvent.deleteButtonFontFamily());
        assertEquals("#ffffff",deleteEvent.deleteButtonColor());
        assertEquals("#d32f2f",deleteEvent.deleteButtonBackgroundColor());

        assertEquals("NO",deleteEvent.noButtonText());
        assertEquals("14px",deleteEvent.noButtonFontSize());
        assertEquals("\"Josefin Sans\"",deleteEvent.noButtonFontFamily());
        assertEquals("#ffffff",deleteEvent.noButtonColor());
        assertEquals("#9c27b0",deleteEvent.noButtonBackgroundColor());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
