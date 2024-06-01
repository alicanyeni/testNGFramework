package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C04_DependsOnMethods extends TestBaseBeforeClassAfterClass {

    // amazon ana sayfasına gidelim
    //Iphone aratalım
    // Sonuc yazısının amazon içerdiğini test edelim


    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
    }

    @Test(dependsOnMethods = "test")
    public void test2() {
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        WebElement result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.getText().contains("Iphone"));
    }
}
