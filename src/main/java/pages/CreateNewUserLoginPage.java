package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewUserLoginPage extends BasePage{

    private By loginTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By changingButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By emailTextBoxCreateUser = By.xpath("//*[@id=\":r0:\"]");
    private By emailTextBoxLogIn = By.xpath("//*[@id=\":r3:\"]");
    private By passwordTextBoxCreateUser = By.xpath("//*[@id=\":r1:\"]");
    private By passwordTextBoxLogIn = By.xpath("//*[@id=\":r4:\"]");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul");
    private By errorDescription = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");

    public CreateNewUserLoginPage(WebDriver driver){
        super(driver);
    }

    public boolean logInPageTitleDisplayed(){
        return elementDisplayed(loginTitle);
    }

    public String getLogIntPageTitle(){
        return getTextFromElement(loginTitle);
    }

    public String getTextFromChangingButton(){
        return getTextFromElement(changingButton);
    }

    public void clickChangingButton(){
        clickElement(changingButton);
    }

    public void insertEmail(String text){
        insertText(emailTextBoxCreateUser, text);
    }

    public void insertEmailLogIn(String text){
        insertText(emailTextBoxLogIn, text);
    }

    public void insertPassword(String password){
        insertText(passwordTextBoxCreateUser, password);
    }

    public void insertPasswordLogIn(String text){
        insertText(passwordTextBoxLogIn, text);
    }

    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }

    public String getErrorDescription(){
        return getTextFromElement(errorDescription);
    }

    public void clickGoButton(){
        clickElement(goButton);
    }

}
