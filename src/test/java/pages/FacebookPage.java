package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='royal_email']")
    public WebElement emailOrPhone;

    @FindBy(xpath = "//*[@data-testid='royal_pass']")
    public WebElement pass;

    @FindBy(xpath = "//*[@data-testid='royal_login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement errorText;
}
