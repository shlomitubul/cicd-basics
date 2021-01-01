package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }


    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }


    public void type(WebElement element,String text) {
        wait.until(ExpectedConditions.visibilityOf(element)) .sendKeys(text);
    }
}