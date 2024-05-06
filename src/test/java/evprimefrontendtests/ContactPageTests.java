package evprimefrontendtests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.SidePanel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactPageTests {

    private WebDriver driver;
    private SidePanel sidePanel;
    private ContactPage contactPage;


    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        contactPage = new ContactPage(driver);

        sidePanel.navigateTo("http://localhost:3000/");
        sidePanel.clickMenuIcon();
        Thread.sleep(3000);
        sidePanel.clickContactLink();

    }

    @Test
    public void contactPageDisplayedTest(){
        assertEquals("http://localhost:3000/contact", contactPage.getUrlFromContactPage());
        assertTrue(contactPage.contactPageTitleDisplayed());

        assertEquals("Want to reach out?",contactPage.getContactPageTitle());
        assertEquals("60px", contactPage.titleFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.titleFontFamily());

    }

    @Test
    public void successfulSendMessageContactPage(){
        contactPage.insertName(RandomStringUtils.randomAlphabetic(15));
        contactPage.insertEmail(RandomStringUtils.randomAlphanumeric(15) + "@mail.com");
        contactPage.insertMessage(RandomStringUtils.randomAlphanumeric(50));
        contactPage.clickSendButton();

    }

    @Test
    public void sendButtonUserInterfaceTest(){
        assertTrue(contactPage.sendButtonDisplayed());

        assertEquals("SEND", contactPage.sendButtonText());
        assertEquals("14px", contactPage.sendButtonFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.sendButtonFontFamily());
        assertEquals("#ffffff",contactPage.senButtonColor() );
        assertEquals("#304ffe", contactPage.sendButtonBackgroundColor());

    }

    @Test
    public void contactPageTextBoxesUserInterfaceTest(){
        assertEquals("16px", contactPage.nameTextBoxFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.nameTextBoxFontFamily());

        assertEquals("16px", contactPage.emailTextBoxFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.emailTextBoxFontFamily());

        assertEquals("16px", contactPage.messageTextBoxFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.messageTextBoxFontFamily());

    }

    @Test
    public void contactElementsTest(){
        assertEquals("Address" + " " + "Rampo Lefkata 1", contactPage.contactElementsText(0) + " " +  contactPage.contactInformationText(0));
        assertEquals("Email" + " " + "ev@rampo.com", contactPage.contactElementsText(1) + " " + contactPage.contactInformationText(1));
        assertEquals("Phone Number" + " " + "+389 75 500 000", contactPage.contactElementsText(2) + " " + contactPage.contactInformationText(2));
        assertEquals("16px", contactPage.contactAttributesFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.contactAttributesFontFamily());
        assertEquals("16px", contactPage.contactInformationFontSize());
        assertEquals("\"Josefin Sans\"", contactPage.contactInformationFontFamily());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
