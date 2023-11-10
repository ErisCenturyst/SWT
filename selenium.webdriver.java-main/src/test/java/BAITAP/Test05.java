package BAITAP;

import POM.RegisterPage;
import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class Test05 {
    public static void test05() {

        String firstname = "HHHuy";
        String lastname = "Trann";
        String email_address = "HHHuytrann24092@gmail.com";
        String password = "huytran";
        String confirm_password = password;


        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            Thread.sleep(1000);

            registerPage.clickMyAccountLink();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.clickCreateAccountLink();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirstName(firstname);
            Thread.sleep(1000);
            registerPage.enterLastName(lastname);
            Thread.sleep(1000);
            registerPage.enterEmail(email_address);
            Thread.sleep(1000);
            registerPage.enterPassword(password);
            Thread.sleep(1000);
            registerPage.enterConfirmPassword(confirm_password);
            Thread.sleep(1000);
            registerPage.clickRegisterButton();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            String aWelcome = ("HELLO, " + firstname.toUpperCase() + " " + lastname.toUpperCase() + "!");
            String bWelcome = driver.findElement(By.cssSelector("p[class='hello'] strong")).getText().toUpperCase();
            System.out.println("bWelcome = " + bWelcome);

            try {
                assertEquals(aWelcome, bWelcome);

            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("tranhoanghuy489@gmail.com");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Tran Hoang Huy share list with you!");
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//span[contains(text(),'Share Wishlist')])[1]")).click();
            Thread.sleep(1000);

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test05.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




