package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateEventPage extends BasePage {

    private By eventTitleTextBox = By.id(":r7:");
    private By eventImageTextBox = By.id(":r8:");
    private By eventDateTextBox = By.id(":r9:");
    private By eventLocationTextBox = By.id(":ra:");
    private By eventDescriptionTextBox = By.id(":rb:");
    private By updateEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");
    private By newErrorPage = By.xpath("//*[@id=\"root\"]/div/h2");

    public UpdateEventPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromUpdateEventButton(){
        return getTextFromElement(updateEventButton);
    }

    public String updateEventButtonFontSize(){
        return remFontSize(updateEventButton);
    }

    public String updateEventButtonFontFamily(){
        return getElementFontFamily(updateEventButton);
    }

    public String updateEventButtonBackGroundColor(){
        return getBackgroundColorFromElement(updateEventButton);
    }

    public void clickUpdateEventButton(){
        clickElement(updateEventButton);
    }

    public void updateTitle(String text){
        insertText(eventTitleTextBox, text);
    }

    public void updateImage(String text){
        insertText(eventImageTextBox, text);
    }

    public void updateDate(String text){
        insertText(eventDateTextBox, text);
    }

    public void updateLocation(String text){
        insertText(eventLocationTextBox, text);
    }

    public void updateDescription(String text){
        insertText(eventDescriptionTextBox, text);
    }

    public boolean errorPageDisplayed(){
        return elementDisplayed(newErrorPage);
    }

    public String errorPageTitle(){
        return getTextFromElement(newErrorPage);
    }

    public void clearTitle(){
        clearField(eventTitleTextBox);
    }

    public void clearImage(){
        clearField(eventImageTextBox);
    }

    public void clearDate(){
        clearField(eventDateTextBox);
    }

    public void clearLocation(){
        clearField(eventLocationTextBox);
    }

    public void clearDescription(){
        clearField(eventDescriptionTextBox);
    }

}
