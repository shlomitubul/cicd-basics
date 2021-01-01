package sanity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.components.TopNavbarArea;

public class registrationTest extends BaseTest {

    @Test
    @Parameters({"email","password","firstname","lastname"})
    public void register_with_current_info(String firstName,String lastName,
                                           String email,String password) {
        TopNavbarArea navbarArea = new TopNavbarArea(driver,wait);
        navbarArea.goToRegistrationPage();

        RegisterPage registerPage =new RegisterPage(driver,wait);
        registerPage.register(firstName,lastName,email,password);

        Assert.assertEquals(registerPage.getPasswordErrorMessage(),"");
    }
}
