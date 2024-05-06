package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.EventsPage;
import pages.CreateNewUserLoginPage;
import pages.SidePanel;

import static org.junit.Assert.*;

public class SidePanelTests {

    private WebDriver driver;
    private SidePanel sidePanel;
    private EventsPage eventsPage;
    private ContactPage contactPage;
    private CreateNewUserLoginPage loginPage;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        eventsPage = new EventsPage(driver);
        contactPage = new ContactPage(driver);
        loginPage = new CreateNewUserLoginPage(driver);

        sidePanel.navigateTo("http://localhost:3000/");
        sidePanel.clickMenuIcon();

    }

    @Test
    public void getAllLinksFromSidePanelTest(){
        assertEquals("Home", sidePanel.allElementsOfSidePanel(0));
        assertEquals("Events", sidePanel.allElementsOfSidePanel(1));
        assertEquals("Contact", sidePanel.allElementsOfSidePanel(2));
        assertEquals("Login", sidePanel.allElementsOfSidePanel(3));

    }

    @Test
    public void homeLinkSidePanelTest(){
        sidePanel.allElementsOfSidePanel(0);
        assertEquals("Home", sidePanel.getTextFromHomeLink());
        assertEquals("16px", sidePanel.getHomeLinkFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getHomeLinkFontFamily());

        sidePanel.clickHomeLink();

    }

    @Test
    public void eventsLinkSidePanelTest() throws InterruptedException {
        sidePanel.allElementsOfSidePanel(1);
        assertEquals("Events", sidePanel.getTextFromEventsLink());
        assertEquals("16px", sidePanel.getEventsLinkFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getEventsLinkFontFamily());

        sidePanel.clickEventsLink();
        Thread.sleep(5000);

        assertTrue(eventsPage.eventsListPageDisplayed());
        Thread.sleep(5000);
        assertEquals("kPKkTf4KSI\n" +
                "2024-05-06", eventsPage.listOfEvents(0));

    }

    @Test
    public void contactLinkSidePanelTest() throws InterruptedException {
        sidePanel.allElementsOfSidePanel(2);
        assertEquals("Contact", sidePanel.getTextFromContactLink());
        assertEquals("16px", sidePanel.getContactLinkFontSize());
        assertEquals("\"Josefin Sans\"",sidePanel.getContactLinkFontFamily());

        sidePanel.clickContactLink();
        Thread.sleep(2500);
        assertTrue(contactPage.contactPageTitleDisplayed());
        assertEquals("Want to reach out?", contactPage.getContactPageTitle());

        sidePanel.clickHomeLink();

    }

    @Test
    public void loginLinkSidePanelTest() throws InterruptedException {
        sidePanel.allElementsOfSidePanel(3);
        assertEquals("Login", sidePanel.getTextFromLoginLink());
        assertEquals("16px", sidePanel.getLoginLinkFontSize());
        assertEquals("\"Josefin Sans\"", sidePanel.getLoginLinkFontFamily());

        sidePanel.clickLoginLink();
        Thread.sleep(2500);
        assertTrue(loginPage.logInPageTitleDisplayed());
        assertEquals("Log in", loginPage.getLogIntPageTitle());

        sidePanel.clickHomeLink();
        loginPage.logInPageTitleDisplayed();

    }

    @Test
    public void closeSidePanelMenuButtonTest() throws InterruptedException {
        assertTrue(sidePanel.allSidePanelLinksDisplayed());
        Thread.sleep(5000);
        sidePanel.clickCloseMenuButton();

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

