package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleEventPage extends BasePage{

    private By singleEventPage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]");
    private By eventTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By dateElement = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By locationElement = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[3]/h6");
    private By descriptionElement = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/span");
    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[2]");
    private By deleteButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private By editEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private By backToEventsButtonHref = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[2]/a");

    public SingleEventPage(WebDriver driver){
        super(driver);
    }

    public boolean singleEventPageDisplayed(){
        return elementDisplayed(singleEventPage);
    }

    public String titleText(){
        return getTextFromElement(eventTitle);
    }

    public String titleFontSize() {
      return remFontSize(eventTitle);
    }

    public String dateFontSize() {
        return remFontSize(dateElement);
    }

    public String titleFontFamily(){
        return getElementFontFamily(eventTitle);
    }

    public boolean dateDisplayed(){
        return elementDisplayed(dateElement);
    }

    public String dateElementText(){
        return getTextFromElement(dateElement);
    }

    public String dateFontFamily(){
        return getElementFontFamily(dateElement);
    }

    public boolean locationDisplayed(){
        return elementDisplayed(locationElement);
    }

    public String locationElementText(){
        return getTextFromElement(locationElement);
    }

    public String locationFontSize() {
        return remFontSize(locationElement);
    }

    public String locationFontFamily(){
        return getElementFontFamily(locationElement);
    }

    public boolean descriptionDisplayed(){
        return elementDisplayed(descriptionElement);
    }

    public String descriptionElementText(){
        return getTextFromElement(descriptionElement);
    }

    public String descriptionFontFamily(){
        return getElementFontFamily(descriptionElement);
    }

    public boolean backToEventsButtonDisplayed(){
        return elementDisplayed(backToEventsButton);
    }

    public String backToEventsButtonText(){
        return getTextFromElement(backToEventsButton);
    }

    public String remBackToEventsButtonFontSize(){
        return remFontSize(backToEventsButton);
    }

    public String backToEventsButtonFontFamily(){
        return getElementFontFamily(backToEventsButton);
    }

    public String backToEventsButtonColor(){
        return getColorFromElement(backToEventsButton);
    }

    public String backToEventsBackgroundColor(){
        return getBackgroundColorFromElement(backToEventsButton);
    }

    public void clickBackToEventsButton(){
        clickElement(backToEventsButton);
    }

    public String hrefFromBackToEventsButton(){
        return getHrefFromPage(backToEventsButtonHref);
    }

    public boolean editEventButtonDisplayed(){
        return elementDisplayed(editEventButton);
    }

    public String editEventButtonText(){
        return getTextFromElement(editEventButton);
    }

    public String editEventButtonFontSize(){
        return remFontSize(editEventButton);
    }

    public String editEventButtonFontFamily(){
        return getElementFontFamily(editEventButton);
    }

    public String editEventButtonBackGroundColor(){
        return getBackgroundColorFromElement(editEventButton);
    }

    public void clickEditEventButton(){
        clickElement(editEventButton);
    }

    public boolean deleteButtonDisplayed(){
        return elementDisplayed(deleteButton);
    }

    public String deleteButtonText(){
        return getTextFromElement(deleteButton);
    }

    public String deleteButtonTextFontSize(){
        return remFontSize(deleteButton);
    }

    public String deleteButtonTextFontFamily(){
        return getElementFontFamily(deleteButton);
    }

    public String deleteButtonBackGroundColor(){
        return getBackgroundColorFromElement(deleteButton);
    }

    public void clickDeleteButton(){
        clickElement(deleteButton);
    }

    public String getCurrentUrlFromPage(){
        return currentUrl();
    }

}
