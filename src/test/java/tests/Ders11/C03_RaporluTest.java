package tests.Ders11;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluTest extends TestBaseRapor {

    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: user@gmail.com ,
    -test data password : 1234 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
*/
    @Test
    public void test() {
        BrcPage brcPage = new BrcPage();
        extentTest = extentReports.createTest("login test", "giriş sayfasının doğrulanması");
        Driver.getDriver().get(ConfigReader.getProperty("BrcUrl"));
        extentTest.info("BRC sitesine gidildi");
        brcPage.loginButton.click();
        extentTest.info("login butonuna tıklandı");
        brcPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        extentTest.info("kullanıcı email adresi girildi.");
        brcPage.pass.sendKeys(ConfigReader.getProperty("brcPass"));
        extentTest.info("kullanıcı parolası girildi");
        brcPage.login.click();
        extentTest.info("login butonuna tıklandı");
        Assert.assertTrue(brcPage.loginControl.isDisplayed());
        extentTest.pass("basarili bir sekilde gecis yapildi");
    }
}
