package BAITAP;


import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.io.File;

@Test
public class Test02 {
    public static void test02() {

        //1. Init web-driver session
        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(1000);


            WebElement SonyPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String SonyPrice = SonyPriceElement.getText();

            Thread.sleep(1000);


            WebElement SonyXperia = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            SonyXperia.click();

            Thread.sleep(1000);


            WebElement SonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String SonyPriceDetail = SonyXperiaDetailPriceElement.getText();

            Thread.sleep(1000);


            if (SonyPrice.equals( SonyPriceDetail)) {
                System.out.println("Equal Price: " + SonyPriceDetail);
            } else {
                System.out.println("Prices do not equal.");
            }
            Thread.sleep(1000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test02.png");


            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




