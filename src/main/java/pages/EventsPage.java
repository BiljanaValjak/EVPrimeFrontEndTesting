package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventsPage extends BasePage{

    private By eventsList = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/ul");
    private By plusButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private By addEventButton = By.xpath("//*[@id=\"SpeedDial-actions\"]/button");

    public EventsPage(WebDriver driver){
        super(driver);
    }

    public Boolean eventsListPageDisplayed(){
        return elementDisplayed(eventsList);
    }

    public String listOfEvents(int num){
        return getListOfElements(eventsList, num);
    }

    public void clickOnEvent(int index){
        chooseEvent(eventsList, index);
    }

    public String getEventText(int index){
        return getTextFromEvent(eventsList, index);
    }

    public void hoverOverPlusButton(){
        hoverOverElement(plusButton);
    }

    public void clickAddEventButton(){
        clickElement(addEventButton);
    }

    public void lastEntry() {
        WebElement dynamicList = driver.findElement(eventsList);

        List<WebElement> listItems = dynamicList.findElements(By.tagName("li"));

        if (!listItems.isEmpty()) {
         WebElement lastItem = listItems.get(listItems.size() - 1);
         lastItem.click();
         } else {
        System.out.println("Dynamic list is empty.");
        }
    }

    public boolean isEventPresents(String id){
        boolean idPresent = isElementPresent(eventsList, id);
        if (idPresent) {
            System.out.println("Record with ID " + id + " is present in the list after deletion.");
        } else {
            System.out.println("Record with ID " + id + " is not present in the list after deletion.");
        }
        return isElementPresent(eventsList, id);
    }
}
