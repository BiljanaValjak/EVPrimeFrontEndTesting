package pages;

import org.openqa.selenium.*;

public class SidePanel extends BasePage{


    private By menuIcon = By.xpath("//*[@id=\"root\"]/div/div/header/div/button");
    private By listOfElementsSidePanel = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul");
    private By homeLink = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[1]");
    private By eventsLink = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[2]");
    private By contactLink = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[3]");
    private By loginLink = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]");
    private By logOutLink = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/ul/li");
    private By closeMenuButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/button");



    public SidePanel (WebDriver driver){
        super(driver);
    }

    public void clickMenuIcon(){
        clickElement(menuIcon);
    }

    public String allElementsOfSidePanel(int index){
        return getListOfElements(listOfElementsSidePanel, index);
    }

    public boolean allSidePanelLinksDisplayed(){
        return elementDisplayed(listOfElementsSidePanel);
    }

    public String getTextFromHomeLink(){
        return getTextFromElement(homeLink);
    }

    public String getHomeLinkFontSize(){
        return getElementFontSize(homeLink);
    }

    public String getHomeLinkFontFamily(){
        return getElementFontFamily(homeLink);
    }

    public void clickHomeLink() throws ElementNotInteractableException {
        driver.findElement(homeLink);
    }

    public String getTextFromEventsLink(){
        return getTextFromElement(eventsLink);
    }

    public String getEventsLinkFontSize(){
        return getElementFontSize(eventsLink);
    }

    public String getEventsLinkFontFamily(){
        return getElementFontFamily(eventsLink);
    }

    public void clickEventsLink(){
        clickElement(eventsLink);
    }

    public String getTextFromContactLink(){
        return getTextFromElement(contactLink);
    }

    public String getContactLinkFontSize(){
        return getElementFontSize(contactLink);
    }

    public String getContactLinkFontFamily(){
        return getElementFontFamily(contactLink);
    }

    public void clickContactLink(){
        clickElement(contactLink);
    }

    public boolean loginLinkDisplayed(){
        try{
            driver.findElement(loginLink);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public String getTextFromLoginLink(){
        return getTextFromElement(loginLink);
    }

    public String getLoginLinkFontSize(){
        return getElementFontSize(loginLink);
    }

    public String getLoginLinkFontFamily(){
        return getElementFontFamily(loginLink);
    }

    public void clickLoginLink(){
        clickElement(loginLink);
    }

    public void clickCloseMenuButton(){
        clickElement(closeMenuButton);
    }

    public boolean logOutLinkDisplayed(){
        try{
            driver.findElement(logOutLink);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void clickLogoutLink(){
        clickElement(logOutLink);
    }

}
