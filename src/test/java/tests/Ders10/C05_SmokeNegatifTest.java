package tests.Ders10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AloTechPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class C05_SmokeNegatifTest {
    AloTechPage aloTechPage = new AloTechPage();
    Actions actions = new Actions(Driver.getDriver());

    // https://demo1.alo-tech.com/ adresine git
    //Email,Password,Login elementlerini locate ediniz
    //Degerleri girildiginde sayfaya girilemedigini test et
    //Sayfayı kapatınız
    @Test(groups = "grup1")
    public void yanlisKulllanici() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        aloTechPage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        aloTechPage.pass.sendKeys(ConfigReader.getProperty("pass"));
        aloTechPage.loginButton.click();
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.failedLoginControl.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisSifre() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        aloTechPage.email.sendKeys(ConfigReader.getProperty("user"));
        aloTechPage.pass.sendKeys(ConfigReader.getProperty("wrongPass"));
        aloTechPage.loginButton.click();
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.failedLoginControl.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciVeSifre() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        aloTechPage.email.sendKeys(ConfigReader.getProperty("wrongUser"));
        aloTechPage.pass.sendKeys(ConfigReader.getProperty("wrongPass"));
        aloTechPage.loginButton.click();
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.failedLoginControl.isDisplayed());
        Driver.closeDriver();
    }
}