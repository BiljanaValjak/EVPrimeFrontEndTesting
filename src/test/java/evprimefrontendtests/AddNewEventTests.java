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

public class AddNewEventTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private CreateNewUserLoginPage loginPage;
    private SingleEventPage singleEventPage;
    private AddNewEventPage addNewEventPage;
    private DeleteEventPage deleteEventPopUp;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);
        singleEventPage = new SingleEventPage(driver);
        addNewEventPage = new AddNewEventPage(driver);
        deleteEventPopUp = new DeleteEventPage(driver);

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
        Thread.sleep(5000);

        sidePanel.clickLoginLink();
        Thread.sleep(5000);

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        Thread.sleep(5000);
        loginPage.clickGoButton();

        Thread.sleep(3000);
        eventsPage.hoverOverPlusButton();
        eventsPage.clickAddEventButton();
    }

    @Test
    public void addNewEventTest() throws InterruptedException {
        addNewEventPage.insertEventTitle(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs4r1eo4XSe9I2FooO8qxCSKk4C-IraXUOHg&s");
        addNewEventPage.insertEventDate(dateBuilder.currentDate());
        addNewEventPage.insertEventLocation(RandomStringUtils.randomAlphanumeric(10));
        addNewEventPage.insertEventDescription(RandomStringUtils.randomAlphanumeric(50));

        addNewEventPage.clickCreateEventButton();
        Thread.sleep(2000);

        assertTrue(eventsPage.eventsListPageDisplayed());
        sidePanel.clickCloseMenuButton();
        Thread.sleep(2000);

        eventsPage.lastEntry();

        String url = singleEventPage.getCurrentUrlFromPage();
        String id = url.substring(url.lastIndexOf("/") + 1);
        System.out.println(id);

        singleEventPage.clickDeleteButton();

        deleteEventPopUp.clickDeleteButtonPopUpMsg();
        assertFalse( eventsPage.isEventPresents(id));
    }

    @Test
    public void addNewEventElementsLabelsAndButtonsUserInterfaceTest(){
        assertEquals("Event Title",addNewEventPage.getEventTitleTextBoxLabel());
        assertEquals("16px",addNewEventPage.eventTitleFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.eventTitleFontFamily());

        assertEquals("Event Image",addNewEventPage.getEventImageTextBoxLabel());
        assertEquals("16px",addNewEventPage.eventImageFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.eventImageFontFamily());

        assertEquals("Event Date",addNewEventPage.getEventDateTextBoxLabel());
        assertEquals("16px",addNewEventPage.eventDateFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.eventDateFontFamily());

        assertEquals("Event Location",addNewEventPage.getEventLocationTextBoxLabel());
        assertEquals("16px",addNewEventPage.eventLocationFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.eventLocationFontFamily());

        assertEquals("Event Description",addNewEventPage.getEventDescriptionTextBoxLabel());
        assertEquals("16px",addNewEventPage.eventDescriptionFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.eventDescriptionFontFamily());

        assertEquals("CREATE EVENT",addNewEventPage.getTexFromCreateEventButton());
        assertEquals("14px",addNewEventPage.createEventButtonFontSize());
        assertEquals("\"Josefin Sans\"",addNewEventPage.createEventButtonFontFamily());
        assertEquals("#304ffe",addNewEventPage.createEventButtonBackgroundColor());
        assertEquals("#ffffff",addNewEventPage.createEventButtonColor());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
