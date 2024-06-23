package tests.Ders10;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_smokePozitifTest {
    //https://www.bluerentalcars.com/ adresine git  login butonuna bas
    // Email ,password ,login butonlarini locate et
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    BrcPage brcPage = new BrcPage();

    @Test(groups = "grup1")
    public void smokePozitiveTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("BrcUrl"));
        brcPage.loginButton.click();
        Thread.sleep(1000);
        brcPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        brcPage.pass.sendKeys(ConfigReader.getProperty("brcPass"));
        brcPage.login.click();
        Thread.sleep(1000);
        Assert.assertTrue(brcPage.loginControl.isDisplayed());
        Driver.quitDriver();
    }
}
