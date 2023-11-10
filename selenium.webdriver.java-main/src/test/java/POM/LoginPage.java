package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By myAccountLink = By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']");
    By emailInputlocator = By.xpath("//input[@id='email']");
    By passwordInputlocator = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//span[contains(text(),'Login')]");


    By UserNameInput = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > input:nth-child(3)");
    By PassWordInput = By.cssSelector("input[type='password']");
    By LoginButton = By.cssSelector("input[title='Login']");

    By SalesLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)");
    By OrderLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)");
    By CloseLink = By.cssSelector("a[title='close'] span");
    By ExportLink = By.cssSelector("button[title='Export'] span span span");

    By ExportToLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > select:nth-child(2)");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void enterEmail(String email) {
        WebElement element = driver.findElement(emailInputlocator);
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordInputlocator);
        element.clear();
        element.sendKeys(password);
    }

    public void clickloginButton() {
        driver.findElement(loginButton).click();
    }


    public void enterUserName(String UserName) {
        WebElement element = driver.findElement(UserNameInput);
        element.clear();
        element.sendKeys(UserName);
    }

    public void enterPassWord(String PassWord) {
        WebElement element = driver.findElement(PassWordInput);
        element.clear();
        element.sendKeys(PassWord);
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void clickCloseLink() {
        driver.findElement(CloseLink).click();
    }


    public void clickSalesLink() {
        driver.findElement(SalesLink).click();
    }

    public void clickOrderLink() {
        driver.findElement(OrderLink).click();
    }

    public void clickExportToLink() {
        driver.findElement(ExportToLink).click();
    }

    public By ChooseTypeExport() {
        WebElement type = driver.findElement(ExportToLink);
        return ChooseTypeExport();
    }

    public void clickExportLink() {
        driver.findElement(ExportLink).click();
    }

}
