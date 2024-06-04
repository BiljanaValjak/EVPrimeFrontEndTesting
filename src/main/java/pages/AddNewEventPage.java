package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewEventPage extends BasePage{

    private By titleTextBox = By.id(":r6:");
    private By titleLabel = By.id(":r6:-label");
    private By imageTextBox = By.id(":r7:");
    private By imageLabel = By.id(":r7:-label");
    private By dateTextBox = By.id(":r8:");
    private By dateLabel = By.id(":r8:-label");
    private By locationTextBox = By.id(":r9:");
    private By locationLabel = By.id(":r9:-label");
    private By descriptionTextBox = By.id(":ra:");
    private By descriptionLabel = By.id(":ra:-label");
    private By createEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");
    private By newErrorPage = By.xpath("//*[@id=\"root\"]/div/h2");

    public AddNewEventPage (WebDriver driver){
        super(driver);
    }

    public String getEventTitleTextBoxLabel(){
        return getTextFromElement(titleLabel);
    }

    public String eventTitleFontSize(){
        return getElementFontSize(titleLabel);
    }

    public String eventTitleFontFamily(){
        return getElementFontFamily(titleLabel);
    }

    public void insertEventTitle(String text){
        insertText(titleTextBox, text);
    }

    public String getEventImageTextBoxLabel(){
        return getTextFromElement(imageLabel);
    }

    public String eventImageFontSize(){
        return getElementFontSize(imageLabel);
    }

    public String eventImageFontFamily(){
        return getElementFontFamily(imageLabel);
    }

    public void insertEventImage(String text){
        insertText(imageTextBox, text);
    }

    public String getEventDateTextBoxLabel(){
        return getTextFromElement(dateLabel);
    }

    public String eventDateFontSize(){
        return getElementFontSize(dateLabel);
    }

    public String eventDateFontFamily(){
        return getElementFontFamily(dateLabel);
    }

    public void insertEventDate(String text){
        insertText(dateTextBox, text);
    }

    public String getEventLocationTextBoxLabel(){
        return getTextFromElement(locationLabel);
    }

    public String eventLocationFontSize(){
        return getElementFontSize(locationLabel);
    }

    public String eventLocationFontFamily(){
        return getElementFontFamily(locationLabel);
    }

    public void insertEventLocation(String text){
        insertText(locationTextBox, text);
    }

    public String getEventDescriptionTextBoxLabel(){
        return getTextFromElement(descriptionLabel);
    }

    public String eventDescriptionFontSize(){
        return getElementFontSize(descriptionLabel);
    }

    public String eventDescriptionFontFamily(){
        return getElementFontFamily(descriptionLabel);
    }

    public void insertEventDescription(String text){
        insertText(descriptionTextBox, text);
    }

    public String getTexFromCreateEventButton(){
        return getTextFromElement(createEventButton);
    }

    public String createEventButtonFontSize(){
        return getElementFontSize(createEventButton);
    }

    public String createEventButtonFontFamily(){
        return getElementFontFamily(createEventButton);
    }

    public String createEventButtonColor(){
        return getColorFromElement(createEventButton);
    }

    public String createEventButtonBackgroundColor(){
        return getBackgroundColorFromElement(createEventButton);
    }

    public void clickCreateEventButton(){
        clickElement(createEventButton);
    }

    public boolean errorPageDisplayed(){
        return elementDisplayed(newErrorPage);
    }

    public String errorPageTitle(){
        return getTextFromElement(newErrorPage);
    }

    public String getUrlFromPage(){
        return currentUrl();
    }

}
