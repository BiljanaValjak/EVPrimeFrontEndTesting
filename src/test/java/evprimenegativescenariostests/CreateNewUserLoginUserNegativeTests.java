package evprimenegativescenariostests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateNewUserLoginPage;
import pages.SidePanel;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;

public class CreateNewUserLoginUserNegativeTests {

    DateBuilder dateBuilder = new DateBuilder();
    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateNewUserLoginPage loginPage;

    String email = "testmail" + dateBuilder.currentTime() + "@mail.com";
    String password = "testpassword";

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
    public void passwordLengthTest() throws InterruptedException {
        loginPage.insertEmail(email);
        loginPage.insertPassword("pass1");

        assertEquals("CREATE USER", loginPage.getTextFromChangingButton());
        loginPage.clickChangingButton();
        assertEquals("Create new user", loginPage.getLogIntPageTitle());
        loginPage.clickGoButton();
        Thread.sleep(5000);

        assertEquals("Invalid password. Must be at least 6 characters long.", loginPage.getErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginPage.getErrorDescription());
    }

    @Test
    public void emptyEmailAndPasswordTest() throws InterruptedException {
        loginPage.clickGoButton();

        Thread.sleep(5000);
        assertEquals("Authentication failed.", loginPage.getErrorDescription());
    }

    @Test
    public void createNewUserEmailExistsTest() throws InterruptedException {
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);

        assertEquals("CREATE USER", loginPage.getTextFromChangingButton());
        loginPage.clickChangingButton();
        assertEquals("Create new user", loginPage.getLogIntPageTitle());
        loginPage.clickGoButton();

        Thread.sleep(5000);

        sidePanel.clickLoginLink();

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password);

        assertEquals("CREATE USER", loginPage.getTextFromChangingButton());
        loginPage.clickChangingButton();
        assertEquals("Create new user", loginPage.getLogIntPageTitle());
        loginPage.clickGoButton();

        assertEquals("Email exists already.", loginPage.getErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginPage.getErrorDescription());
    }

    @Test
    public void createNewUserInvalidEmailTest() throws InterruptedException {
        loginPage.insertEmail(RandomStringUtils.randomAlphanumeric(10) + "mail.com");
        loginPage.insertPassword(password);

        loginPage.clickChangingButton();
        assertEquals("Create new user", loginPage.getLogIntPageTitle());

        loginPage.clickGoButton();
        Thread.sleep(5000);
        assertEquals("Invalid email.", loginPage.getErrorMessage());
        assertEquals("User signup failed due to validation errors.", loginPage.getErrorDescription());
    }

    @Test
    public void loginInvalidPasswordTest() throws InterruptedException {
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);

        loginPage.clickChangingButton();
        loginPage.clickGoButton();

        Thread.sleep(5000);

        sidePanel.clickLoginLink();

        loginPage.insertEmailLogIn(email);
        loginPage.insertPasswordLogIn(password + "@");
        loginPage.clickGoButton();

        Thread.sleep(5000);
        assertEquals("Invalid email or password entered.", loginPage.getErrorMessage());
        assertEquals("Invalid credentials.", loginPage.getErrorDescription());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
