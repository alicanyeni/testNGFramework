package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {


    @Test
    public void testAll() throws IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("HepsiBuradaURL"));
        //Ve sayfanın resmini alınız
        ReusableMethods.getScreenshot("Tüm ekran resmi");
        //Sayfayı kapatınız
        Driver.quitDriver();


    }

    @Test
    public void testWebElement() throws IOException {
        AmazonPage amazonPage = new AmazonPage();

        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        ReusableMethods.wait(1);

        //Iphone aratınız
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);

        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("elementin ekran goruntusu", amazonPage.resultText);
    }
}
