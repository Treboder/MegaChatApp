package mega_chat_app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectChat {

    @FindBy(id="greeting")
    private WebElement greeting;

    @FindBy(id="messageText")
    private WebElement messageText;

    @FindBy(id="messageType")
    private WebElement messageType;

    @FindBy(id="submit-button")
    private WebElement submitButton;

    @FindBy(id="messageHistory")
    private WebElement messageHistory;

    public PageObjectChat(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getGreeting() {
        return greeting.getText();
    }

    public void sendMessage(String message) {
        messageText.sendKeys(message);
        submitButton.click();
    }

    public String getMessageHistory() {
        return messageHistory.getText();
    }








}
