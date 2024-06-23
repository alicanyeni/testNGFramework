package tests.Ders11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_WindowHandlesReusableMethod {

    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Click Here butonuna basın.
    // acilan yeni tab'in title'inin "New Window" oldugunu test edin
    @Test
    public void testName() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']"));
        ReusableMethods.wait(1);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.quitDriver();
    }
}
