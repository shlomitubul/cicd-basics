package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInBPage extends PageObject {

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;


    public SignInBPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String password) {
        type(passwordField,password);
        waitAndClick(signInButton);
    }

    public String getPasswordErrorMessage() {
        try {
           return driver.findElement(By.xpath("//p[@id='signin-error-msg']")).getText();
        } catch (Exception ex){
            return "";
        }
    }
}
