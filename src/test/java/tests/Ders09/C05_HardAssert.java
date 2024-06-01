package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C05_HardAssert extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test() throws InterruptedException {
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();

        //2-title in Amazon içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());

        //4-arama kutusuna Iphone yazıp aratın
        searchBox.sendKeys("iPhone", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement result= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.isDisplayed());

        //6-arama sonucunun Iphone içerdigini test
        Assert.assertTrue(result.getText().contains("iPhone"));


    }
}
