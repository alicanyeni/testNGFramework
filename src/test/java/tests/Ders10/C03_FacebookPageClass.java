package tests.Ders10;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_FacebookPageClass {
    Faker faker;
    @Test
    public void test() throws InterruptedException {
        FacebookPage facebookPage = new FacebookPage();

        //https://www.facebook.com/ adresine gidin
        //POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));
        faker = new Faker();

        //Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        facebookPage.emailOrPhone.sendKeys(faker.internet().emailAddress());
        facebookPage.pass.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();

        Thread.sleep(1000);
        //Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.errorText.isDisplayed());

    }
}
