package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInAPage extends PageObject {
    @FindBy(xpath = "//input[@id='userid']")
    private WebElement usernameField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueField;

    public SignInAPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void insertUsername(String username) {
        type(usernameField,username);
    }

    public void continueToPasswordPage() {
        waitAndClick(continueField);
    }
}
