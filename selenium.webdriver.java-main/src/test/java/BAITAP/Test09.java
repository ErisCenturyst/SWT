package BAITAP;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;


@Test
public class Test09 {
    public static void test09() {

        String CouponCode = "GURU50";


        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            Thread.sleep(1000);
            checkoutPage.clickMobileLink();
            Thread.sleep(1000);
            checkoutPage.clickAddIphoneLink();
            Thread.sleep(1000);
            String GrandTotalBefore = checkoutPage.getGrandTotalBefore();
            Thread.sleep(1000);
            System.out.println("GrandTotal ban đầu: " + GrandTotalBefore);
            checkoutPage.enterCouponCode(CouponCode);
            Thread.sleep(1000);
           checkoutPage.clickAppylyLink();
            Thread.sleep(1000);
            String discount = checkoutPage.getDiscount();
            Thread.sleep(1000);
            String price = checkoutPage.getPrice();
            Thread.sleep(1000);
            String pricediscount = checkoutPage.getPriceDiscount();
            Thread.sleep(1000);
            System.out.println(discount + "" + pricediscount);
            Thread.sleep(1000);
            String GrandTotalAfter = checkoutPage.getGrandTotalAfter();
            Thread.sleep(1000);
            System.out.println("GrandTotal sau khi áp dụng mã giảm: " + GrandTotalAfter);


            Assert.assertNotEquals(GrandTotalBefore,GrandTotalAfter);
            System.out.println("Mã giảm được áp dụng.");




            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test09.png");
            FileUtils.copyFile(srcFile, new File(png));


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }

    }
}




