package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public abstract class BasePage {

    public WebDriver driver;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void clickElement(By element){
        driver.findElement(element).click();
    }

    public boolean elementDisplayed(By element){
        try{
            driver.findElement(element).isDisplayed();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public String getTextFromElement(By element){
        return driver.findElement(element).getText();
    }

    public String getElementFontSize(By element){
        return driver.findElement(element).getCssValue("font-size");
    }

    public String getElementFontFamily(By element){
        return driver.findElement(element).getCssValue("font-family");
    }

    public String getListOfElements(By element, int index) {
        WebElement listOfElements = driver.findElement(element);
        List<WebElement> options =listOfElements.findElements(By.tagName("li"));
        return options.get(index).getText();
    }

    public String getListOfElementsContact(By element, int index) {
        WebElement listOfElements = driver.findElement(element);
        List<WebElement> options =listOfElements.findElements(By.tagName("p"));
        return options.get(index).getText();
    }

    public boolean isElementPresent(By locator, String id) {
        List<WebElement> elementsList = driver.findElements(locator);
        for (WebElement element : elementsList) {
            if (element.getAttribute("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void chooseEvent(By element, int index){
        WebElement events =  driver.findElement(element);
        List<WebElement> listItems = events.findElements(By.tagName("li"));
        listItems.get(index).click();
    }

    public String getTextFromEvent(By element, int index){
        WebElement events =  driver.findElement(element);
        List<WebElement> listItems = events.findElements(By.tagName("li"));
        return listItems.get(index).getText();
    }

    public String getColorFromElement(By element){
        Color elementColor = Color.fromString(driver.findElement(element).getCssValue("color"));
        return elementColor.asHex();
    }

    public String getBackgroundColorFromElement(By element){
        Color elementColor = Color.fromString(driver.findElement(element).getCssValue("background-color"));
        return elementColor.asHex();
    }

    public void insertText(By element, String text){
        driver.findElement(element).sendKeys(text);
    }

    public void hoverOverElement(By locator){
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public String getHrefFromPage(By locator){
        WebElement element = driver.findElement(locator);
        return element.getAttribute("href");
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public void clearField(By element){
        driver.findElement(element).clear();
    }

    public String remFontSize(By locator) {
        WebElement element = driver.findElement(locator);
        String pxValue = element.getCssValue("font-size");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Double remValue = (Double) js.executeScript(
                "return parseFloat(arguments[0]) / parseFloat(getComputedStyle(document.documentElement).fontSize);",
                pxValue);
        return remValue.toString();
    }
}
