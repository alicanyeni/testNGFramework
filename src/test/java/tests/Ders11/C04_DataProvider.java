package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C04_DataProvider {

    //amazona gidelim
    //java, selenium, samsung ve iphone icin arama yapalim
    //sonuclarin aradigimiz kelime icerdigini test edelim

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"Java"}, {"Selenium"}, {"Samsung"}, {"iPhone"}};
    }

    @Test(dataProvider = "aranacakKelimeler",groups = "grup1")
    public void test(String kelimeler) {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        amazonPage.searchBox.sendKeys(kelimeler, Keys.ENTER);
        String actualData = amazonPage.resultText.getText();
        Assert.assertTrue(actualData.contains(kelimeler));
        Driver.quitDriver();
    }
}
