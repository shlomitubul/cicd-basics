package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.MainSearchArea;

import java.util.List;

public class HomePage extends PageObject {
    protected MainSearchArea mainSearchArea;

    @FindBy(xpath = "rtm_list1")
    public WebElement mainBanner;


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        //TODO replace new with Guice DI
        mainSearchArea= new MainSearchArea(driver,wait);
    }

    public void clickOnBanner() {
        waitAndClick(mainBanner);
    }


}
