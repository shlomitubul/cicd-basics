package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

public class MainSearchArea extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[@value='Search']")
    public WebElement searchButton;

    public MainSearchArea(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void search(String text) {
        type(searchBar,text);
        waitAndClick(searchButton);
    }


}
