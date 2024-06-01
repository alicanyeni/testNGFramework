package tests.Ders10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AmazonPageClass {

    @Test
    public void test() throws InterruptedException {

        AmazonPage amazonPage = new AmazonPage();

        //Amazon sayfasına git.
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        Thread.sleep(1000);
        amazonPage.cookie.click();

        //Selenium kelimesini arat.
        amazonPage.searchBox.sendKeys("Selenium", Keys.ENTER);

        //Sonuç yazısının Selenium içerdiğini kontrol et.
        String expectedResult = "Selenium";
        String actualData = amazonPage.resultText.getText();
        Assert.assertTrue(actualData.contains(expectedResult));
        Driver.closeDriver();
    }
}
