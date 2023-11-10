package BAITAP;


import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Set;

@Test
public class Test04 {
    public static void test04() {


        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(1000);

            WebElement CpSony = driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[2]"));
            CpSony.click();
            Thread.sleep(1000);
            WebElement CpIphone = driver.findElement(By.xpath("(//a[@class='link-compare'][normalize-space()='Add to Compare'])[3]"));
            CpIphone.click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("(//span[contains(text(),'Compare')])[2]")).click();
            Thread.sleep(1000);

            String MainWindow = driver.getWindowHandle();
            System.out.println(MainWindow);
            Set<String> windows = driver.getWindowHandles();
            for(String window:windows){
                System.out.println(window);
                if(!MainWindow.equalsIgnoreCase(window)){
                    driver.switchTo().window(window);
                    Thread.sleep(1000);
                    System.out.println("Đã chuyển đến Popup Compare Product");
                    System.out.println(driver.getTitle());
                }
            }
            Thread.sleep(1000);

            String title = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText();

            System.out.println(title);
            try {
                AssertJUnit.assertEquals("COMPARE PRODUCTS",title);
            } catch (Error e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test04.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(1000);



        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




