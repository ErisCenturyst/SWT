package BAITAP;


import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;

@Test
public class Test03 {
    public static void test03() {


        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(1000);

            WebElement Add = driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[2]"));
            Add.click();
            Thread.sleep(1000);
            WebElement Qty = driver.findElement(By.xpath("//input[@title='Qty']"));
            Qty.clear();
            Thread.sleep(1000);
            Qty.sendKeys("1000");

            WebElement Update = driver.findElement(By.xpath("(//span[contains(text(),'Update')])[3]"));
            Update.click();

            String error = driver.findElement(By.xpath(" //p[@class='item-msg error']")).getText();
            System.out.println(error);
            try {
                AssertJUnit.assertEquals("The requested quantity for \"Sony Xperia\" is not available", error);


            } catch (Error e) {
                e.printStackTrace();
            }

            Thread.sleep(1000);
            WebElement Emptycartlink = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
            Emptycartlink.click();
            Thread.sleep(1000);

            String shoppingcart = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText();

            System.out.println(shoppingcart);
            try {
                AssertJUnit.assertEquals("SHOPPING CART IS EMPTY", shoppingcart);
            } catch (Error e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test03.png");
            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




