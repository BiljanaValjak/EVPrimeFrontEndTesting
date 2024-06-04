package evprimenegativescenariostests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.SidePanel;

public class ContactPageNegativeTests {

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
        Thread.sleep(2000);
        sidePanel.clickContactLink();
    }

    @Test
    public void emptyNameTextBoxContactPage() {
        contactPage.insertName("");
        contactPage.insertEmail(RandomStringUtils.randomAlphanumeric(15) + "@mail.com");
        contactPage.insertMessage(RandomStringUtils.randomAlphanumeric(50));

        contactPage.clickSendButton();
    }

    @Test
    public void invalidEmailContactPage(){
        contactPage.insertName(RandomStringUtils.randomAlphanumeric(15));
        contactPage.insertEmail(RandomStringUtils.randomAlphanumeric(15) + "mail.com");
        contactPage.insertMessage(RandomStringUtils.randomAlphanumeric(50));

        contactPage.clickSendButton();
    }

    @Test
    public void emptyMessageTextBoxContactPage(){
        contactPage.insertName(RandomStringUtils.randomAlphanumeric(15));
        contactPage.insertEmail(RandomStringUtils.randomAlphanumeric(15) + "@mail.com");
        contactPage.insertMessage("");

        contactPage.clickSendButton();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
