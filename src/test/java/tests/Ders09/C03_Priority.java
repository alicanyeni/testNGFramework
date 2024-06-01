package tests.Ders09;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

    @Test(priority = -5)
    public void testAmazon() {
        driver.get("https://www.amazon.com.tr");
    }

    @Test(priority = 100)
    public void testBuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 1)
    public void testHepsiBurada() {
        driver.get("https://www.hepsiburada.com");
    }
}
