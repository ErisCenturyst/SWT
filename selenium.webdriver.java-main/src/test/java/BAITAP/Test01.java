package BAITAP;

import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class Test01 {
    public static void test01() {

        //1. Init web-driver session
        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");
            String demo = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demo);
            try {
                AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demo);


            } catch (Error e) {
                e.printStackTrace();
            }


            Thread.sleep(1000);

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(1000);
            new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
            Thread.sleep(1000);


            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test01.png");


            FileUtils.copyFile(srcFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
