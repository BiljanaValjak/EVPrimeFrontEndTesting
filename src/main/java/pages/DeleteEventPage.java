package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteEventPage extends BasePage {

    private By deletePopUp = By.xpath("/html/body/div[2]/div[3]");
    private By deleteMessage = By.xpath("/html/body/div[2]/div[3]/div/h5");
    private By deleteButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private By noButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[2]");

    public DeleteEventPage(WebDriver driver){
        super(driver);
    }

    public Boolean deletePopUpDisplayed(){
       return elementDisplayed(deletePopUp);
    }

    public String deleteMessageText(){
        return getTextFromElement(deleteMessage);
    }

    public String deleteMessageFontSize(){
        return getElementFontSize(deleteMessage);
    }

    public String deleteMessageFontFamily(){
        return getElementFontFamily(deleteMessage);
    }

    public String deleteButtonText(){
        return getTextFromElement(deleteButton);
    }

    public String deleteButtonFontSize(){
        return getElementFontSize(deleteButton);
    }

    public String deleteButtonFontFamily(){
        return getElementFontFamily(deleteButton);
    }

    public String deleteButtonColor(){
        return getColorFromElement(deleteButton);
    }

    public String deleteButtonBackgroundColor(){
        return getBackgroundColorFromElement(deleteButton);
    }

    public void clickDeleteButtonPopUpMsg(){
        clickElement(deleteButton);
    }

    public String noButtonText(){
        return getTextFromElement(noButton);
    }

    public String noButtonFontSize(){
        return getElementFontSize(noButton);
    }

    public String noButtonFontFamily(){
        return getElementFontFamily(noButton);
    }

    public String noButtonColor(){
        return getColorFromElement(noButton);
    }

    public String noButtonBackgroundColor(){
        return getBackgroundColorFromElement(noButton);
    }

    public void clickNoButton(){
        clickElement(noButton);
    }
}
