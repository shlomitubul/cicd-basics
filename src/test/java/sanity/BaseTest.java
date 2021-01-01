package sanity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public final long  TIME_OUT = 10L;

    @Parameters({"browser","version","url"})
    @BeforeClass()
    public void init(String browser,String version,String url) {
        initDriver(browser,version);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void initDriver(String browser,String version) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version(version).setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().version(version).setup();
            driver = new FirefoxDriver();
        }
        else throw new IllegalArgumentException("invalid browser type:\t" + browser);


        wait = new WebDriverWait(driver,TIME_OUT);
    }

    @AfterClass
    public void dispose() {
        driver.close();
    }
}
