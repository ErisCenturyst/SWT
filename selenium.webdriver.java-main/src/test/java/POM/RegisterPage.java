package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;

    By myAccountLink = By.xpath("(//a[@title='My Account'][normalize-space()='My Account'])[2]");
    By crateAccountLink = By.xpath("//a[@title='Create an Account']");
    By firstnameInputlocator = By.xpath("//input[@id='firstname']");
    By lastnameInputlocator = By.xpath("//input[@id='lastname']");
    By emailInputlocator = By.xpath("//input[@id='email_address']");
    By passwordInputlocator = By.xpath("//input[@id='password']");
    By confirmPasswordInputlocator = By.xpath("//input[@id='confirmation']");
    By registerButton = By.xpath("//span[contains(text(),'Register')]");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickCreateAccountLink() {

        driver.findElement(crateAccountLink).click();
    }

    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(firstnameInputlocator);
        element.clear();
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(lastnameInputlocator);
        element.clear();
        element.sendKeys(lastName);
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

    public void enterConfirmPassword(String confirmPassword) {
        WebElement element = driver.findElement(confirmPasswordInputlocator);
        element.clear();
        element.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }





}
