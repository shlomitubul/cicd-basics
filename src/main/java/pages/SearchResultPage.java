package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends PageObject {

    //TODO Add pagination
    @FindBys(@FindBy(xpath = "//h3[@class='s-item__title s-item__title--has-tags']"))
    public List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
