package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C06_SoftAssert extends TestBaseCross {
    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Title is false!");

        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(searchBox.isEnabled(), "SearchBox is not enabled!");

        //4-arama kutusuna Iphone yazıp aratın
        searchBox.sendKeys("iPhone", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(result.isDisplayed(), "SearchBox is not working!");

        //6-arama sonucunun Iphone içerdigini test
        softAssert.assertTrue(result.getText().contains("iPhone"), "SearchBox not working properly!");

        softAssert.assertAll();
        System.out.println("If there is an error in the system, this text will not be read.");
    }
}
