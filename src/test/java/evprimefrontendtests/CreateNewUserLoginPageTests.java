package evprimefrontendtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateNewUserLoginPage;
import pages.SidePanel;
import util.DateBuilder;

import static org.junit.Assert.*;

public class CreateNewUserLoginPageTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateNewUserLoginPage loginPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        loginPage = new CreateNewUserLoginPage(driver);

        sidePanel.navigateTo("http://localhost:3000/");
        sidePanel.clickMenuIcon();
        Thread.sleep(3000);
        sidePanel.clickLoginLink();
    }

    @Test
    public void loginPageDisplayedTest(){
        assertTrue(loginPage.logInPageTitleDisplayed());
        assertEquals("Log in",loginPage.getLogIntPageTitle());
    }

    @Test
    public void createNewUserAndLogInTest() throws InterruptedException {
        String email = "testmail" + dateBuilder.currentTime() + "@mail.com";
        String password = "testpassword";

        loginPage.insertEmail(email);
        loginPage.insertPassword(password);

        assertEquals("CREATE USER",loginPage.getTextFromChangingButton());
        loginPage.clickChangingButton();
        assertEquals("Create new user", loginPage.getLogIntPageTitle());
        loginPage.clickGoButton();
        Thread.sleep(5000);

        sidePanel.clickLoginLink();
        Thread.sleep(5000);

        assertEquals("Log in", loginPage.getLogIntPageTitle());

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        Thread.sleep(5000);
        loginPage.clickGoButton();

        assertTrue(sidePanel.loginLinkDisplayed());

        assertFalse(sidePanel.logOutLinkDisplayed());
        Thread.sleep(5000);

        sidePanel.clickLogoutLink();
        Thread.sleep(5000);

        assertTrue(sidePanel.loginLinkDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}