package pages;

import org.openqa.selenium.*;
public class ContactPage extends BasePage {

    private By contactPageTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/h2");
    private By nameTextBox = By.xpath("//*[@id=\":r0:\"]");
    private By emailTextBox = By.xpath("//*[@id=\":r1:\"]");
    private By messageTextBox = By.xpath("//*[@id=\":r2:\"]");
    private By sendButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    private By contactElements = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[2]/div[1]");
    private By contactInformation = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[2]/div[2]");

    public ContactPage (WebDriver driver){
        super(driver);
    }

    public boolean contactPageTitleDisplayed(){
        return elementDisplayed(contactPageTitle);
    }

    public String getContactPageTitle(){
        return getTextFromElement(contactPageTitle);
    }

    public String titleFontSize(){
        return getElementFontSize(contactPageTitle);
    }

    public String titleFontFamily(){
        return getElementFontFamily(contactPageTitle);
    }

    public void insertName(String name){
        if(name.length() > 15){
            throw new IllegalArgumentException("Maximum number of characters must be lower than 15");
        }
        insertText(nameTextBox, name);
    }

    public String nameTextBoxFontSize(){
        return getElementFontSize(nameTextBox);
    }

    public String nameTextBoxFontFamily(){
        return getElementFontFamily(nameTextBox);
    }

    public void insertEmail(String email){
        insertText(emailTextBox, email);
    }

    public String emailTextBoxFontSize(){
        return getElementFontSize(emailTextBox);
    }

    public String emailTextBoxFontFamily(){
        return getElementFontFamily(emailTextBox);
    }

    public void insertMessage(String message){
        if(message.length() > 50){
            throw new IllegalArgumentException("Maximum number of characters must be lower than 50");
        }
        insertText(messageTextBox, message);
    }

    public String messageTextBoxFontSize(){
        return getElementFontSize(messageTextBox);
    }

    public String messageTextBoxFontFamily(){
        return getElementFontFamily(messageTextBox);
    }

    public void clickSendButton(){
        clickElement(sendButton);
    }

    public boolean sendButtonDisplayed(){
        return elementDisplayed(sendButton);
    }

    public String sendButtonText(){
        return getTextFromElement(sendButton);
    }

    public String sendButtonFontSize(){
        return getElementFontSize(sendButton);
    }

    public String sendButtonFontFamily(){
        return getElementFontFamily(sendButton);
    }

    public String senButtonColor(){
        return getColorFromElement(sendButton);
    }

    public String sendButtonBackgroundColor(){
        return getBackgroundColorFromElement(sendButton);
    }

    public String contactElementsText(int index){
        return getListOfElementsContact(contactElements,index);
    }

    public String contactInformationText(int index){
        return getListOfElementsContact(contactInformation, index);
    }

    public String contactAttributesFontSize(){
        return getElementFontSize(contactElements);
    }

    public String contactAttributesFontFamily(){
        return getElementFontFamily(contactElements);
    }

    public String contactInformationFontSize(){
        return getElementFontSize(contactInformation);
    }

    public String contactInformationFontFamily(){
        return getElementFontFamily(contactInformation);
    }

    public String getUrlFromContactPage(){
        return currentUrl();
    }

}

