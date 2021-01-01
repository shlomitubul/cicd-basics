package sanity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInAPage;
import pages.SignInBPage;
import pages.components.TopNavbarArea;

public class SignInTest extends BaseTest {

    @Parameters({"username","password"})
    @Test
    public void signing_with_current_credentials(String username,String password) {
        TopNavbarArea navbarArea = new TopNavbarArea(driver,wait);
        navbarArea.goTosignInPage();

        SignInAPage signInAPage = new SignInAPage(driver,wait);
        signInAPage.insertUsername(username);
        signInAPage.continueToPasswordPage();

        SignInBPage signInBPage = new SignInBPage(driver,wait);
        signInBPage.login(password);

        Assert.assertEquals(signInBPage.getPasswordErrorMessage(),"");
    }
}
