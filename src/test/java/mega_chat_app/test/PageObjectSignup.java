package mega_chat_app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectSignup {

    @FindBy(id="inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id="inputLastName")
    private WebElement inputLastName;

    @FindBy(id="inputUsername")
    private WebElement inputUser;

    @FindBy(id="inputPassword")
    private WebElement inputPassword;

    @FindBy(id="submit-button")
    private WebElement submitButton;

    @FindBy(id="success-msg")
    private WebElement successMessage; // You successfully signed up! Please continue to the login page.

    @FindBy(id="login-link")
    private WebElement loginLink;

    @FindBy(id="error-msg")
    private WebElement errorMessage;

    public PageObjectSignup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signup(String firstName, String lastName, String user, String pwd) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputUser.sendKeys(user);
        inputPassword.sendKeys(pwd);
        submitButton.click();
    }

    public void login() {
        loginLink.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}












