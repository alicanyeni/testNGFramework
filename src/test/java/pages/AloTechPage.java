package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AloTechPage {
    public AloTechPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='data-email']")
    public WebElement email;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement pass;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//div[@class='LoginLayout_LoginTemplate_Title__ECgL_ MuiBox-root css-0']")
    public WebElement failedLoginControl;
}