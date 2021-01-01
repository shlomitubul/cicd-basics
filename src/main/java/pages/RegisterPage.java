package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends PageObject {
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement registerButton;




    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void register(String firstName,String lastName,String email,String password) {
        type(firstNameField,firstName);
        type(lastNameField,lastName);
        type(emailField,email);
        type(passwordField,password);
        waitAndClick(registerButton);
    }

    public String getPasswordErrorMessage() {
      try {
          return driver.findElement(By.xpath("//div[@id='password_err']")).getText();
      } catch (Exception ex) {
          return "";
      }
    }
}
