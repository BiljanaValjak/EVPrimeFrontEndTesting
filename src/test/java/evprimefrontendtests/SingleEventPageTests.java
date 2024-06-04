package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingleEventPageTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private SingleEventPage singleEventPage;
    private CreateNewUserLoginPage loginPage;

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
        Thread.sleep(5000);

        sidePanel.clickLoginLink();
        Thread.sleep(5000);

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        Thread.sleep(5000);
        loginPage.clickGoButton();

        Thread.sleep(3000);
        sidePanel.clickEventsLink();
        Thread.sleep(3000);
        eventsPage.clickOnEvent(0);
        Thread.sleep(3000);
    }

    @Test
    public void eventTitleTest(){
        assertTrue(singleEventPage.singleEventPageDisplayed());

        assertEquals("kPKkTf4KSI", singleEventPage.titleText());
        assertEquals("3.75", singleEventPage.titleFontSize());
        assertEquals("\"Josefin Sans\"", singleEventPage.titleFontFamily());
    }

    @Test
    public void eventDateTest(){
        assertTrue(singleEventPage.dateDisplayed());

        assertEquals("2024-05-06", singleEventPage.dateElementText());
        assertEquals("0.875", singleEventPage.dateFontSize());
        assertEquals("\"Josefin Sans\"",singleEventPage.dateFontFamily());
    }

    @Test
    public void eventLocationTest(){
        assertTrue(singleEventPage.locationDisplayed());

        assertEquals("xV1wRVn3LV", singleEventPage.locationElementText());
        assertEquals("0.875", singleEventPage.locationFontSize());
        assertEquals("\"Josefin Sans\"",singleEventPage.locationFontFamily());
    }

    @Test
    public void eventDescriptionTest(){
        assertTrue(singleEventPage.descriptionDisplayed());
        assertEquals("My206riD9rCoGtxs3EpVKvhgaFQVkB3j38JVbpyUQCIztdNSV8", singleEventPage.descriptionElementText());
        assertEquals("\"Josefin Sans\"",singleEventPage.descriptionFontFamily());
    }

    @Test
    public void backToEventsButtonUserInterfaceTest() throws InterruptedException {
        assertTrue(singleEventPage.backToEventsButtonDisplayed());

        assertEquals("BACK TO EVENTS", singleEventPage.backToEventsButtonText());
        assertEquals("0.875", singleEventPage.remBackToEventsButtonFontSize());
        assertEquals("\"Josefin Sans\"",singleEventPage.backToEventsButtonFontFamily());
        assertEquals("#ffffff", singleEventPage.backToEventsButtonColor());
        assertEquals("#9c27b0",singleEventPage.backToEventsBackgroundColor());

         assertEquals("http://localhost:3000/events", singleEventPage.hrefFromBackToEventsButton());
         singleEventPage.clickBackToEventsButton();

         Thread.sleep(3000);
         assertTrue(eventsPage.eventsListPageDisplayed());
    }

    @Test
    public void editEventButtonUserInterfaceTest(){
        assertTrue(singleEventPage.editEventButtonDisplayed());

        assertEquals("EDIT EVENT", singleEventPage.editEventButtonText());
        assertEquals("0.875", singleEventPage.editEventButtonFontSize());
        assertEquals("\"Josefin Sans\"", singleEventPage.editEventButtonFontFamily());
        assertEquals("#304ffe", singleEventPage.editEventButtonBackGroundColor());
    }

    @Test
    public void deleteButtonUserInterfaceTest(){
        assertTrue(singleEventPage.deleteButtonDisplayed());

        assertEquals("DELETE EVENT", singleEventPage.deleteButtonText());
        assertEquals("0.875", singleEventPage.deleteButtonTextFontSize());
        assertEquals("\"Josefin Sans\"", singleEventPage.deleteButtonTextFontFamily());
        assertEquals("#d32f2f", singleEventPage.deleteButtonBackGroundColor());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
