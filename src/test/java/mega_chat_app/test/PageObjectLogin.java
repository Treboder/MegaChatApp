package mega_chat_app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectLogin {

    @FindBy(id="inputUsername")
    private WebElement inputUser;

    @FindBy(id="inputPassword")
    private WebElement inputPassword;

    @FindBy(id="submit-button")
    private WebElement submitButton;

    @FindBy(id="signup-link")
    private WebElement signupLink;

    @FindBy(id="error-msg")
    private WebElement errorMessage; // Invalid username or password

    @FindBy(id="logout-msg")
    private WebElement logoutMessage; // You have been logged out

    public PageObjectLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pwd) {
        inputUser.sendKeys(user);
        inputPassword.sendKeys(pwd);
        submitButton.click();
    }

    public void signup() {
        signupLink.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}


