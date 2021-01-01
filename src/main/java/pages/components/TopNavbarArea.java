package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

public class TopNavbarArea extends PageObject {
    @FindBy(xpath = "//span[text()='Hi! ']//a[text()='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "//span[text()='or ']//a[text()='register']")
    public WebElement registerLink;

    @FindBy(xpath = "//a[text()=' Daily Deals']")
    public WebElement dailyDealsLink;

    @FindBy(xpath = "//a[text()=' Help & Contact']")
    public WebElement helpAndContactLink;

    public TopNavbarArea(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goTosignInPage() {
        waitAndClick(signInLink);
    }

    public void goToRegistrationPage() {
        waitAndClick(registerLink);
    }

    public TopNavbarArea goToDailyDeals() {
        waitAndClick(dailyDealsLink);
        return this;
    }

    public void goToHelpAndContact() {
        waitAndClick(helpAndContactLink);
    }
}
