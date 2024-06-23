package tests.Ders11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_DataProvider {
    @DataProvider
    public static Object[][] loginTest() {
        return new Object[][]{{"user@gmail.com", "12345"}, {"user1@gmail.com", "12345"}, {"user2@gmail.com", "12345"}};
    }

    BrcPage brcPage = new BrcPage();

    //https://www.bluerentalcars.com/ adresine git
    //login butonuna bas
    //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
    //login butonuna tiklayin
    //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

    @Test(dataProvider = "loginTest")
    public void test(String mail, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("BrcUrl"));
        brcPage.loginButton.click();
        brcPage.email.sendKeys(mail);
        brcPage.pass.sendKeys(password);
        brcPage.login.click();
        Assert.assertTrue(brcPage.login.isDisplayed());
    }
}
