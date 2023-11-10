package BAITAP;


import POM.AdminPanelPage;
import POM.LoginPage;
import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.File;


@Test
public class Test10 {
    public static void test10() {

        String CouponCode = "GURU50";
        String username = "user01";
        String password = "guru99com";
        String csv = "CSV";
        String OrderId = "1";
        String From = "11/7/2023";
        String To = "11/11/2023";




        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/index.php/backendlogin");
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.enterUserName(username);
            Thread.sleep(1000);
            loginPage.enterPassWord(password);
            Thread.sleep(1000);
            loginPage.clickLoginButton();
            Thread.sleep(3000);
            loginPage.clickCloseLink();
            Thread.sleep(1000);

            loginPage.clickSalesLink();
            Thread.sleep(1000);
            loginPage.clickOrderLink();
            Thread.sleep(2000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
            adminPanelPage.enterOrderIdLink(OrderId);
            Thread.sleep(1000);
            adminPanelPage.enterFromLink(From);
            Thread.sleep(1000);
            adminPanelPage.enterToLink(To);
            Thread.sleep(1000);
            adminPanelPage.clickSearchLink();
            Thread.sleep(3000);
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test10.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




