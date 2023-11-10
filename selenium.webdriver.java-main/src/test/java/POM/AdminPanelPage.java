package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPanelPage {
    WebDriver driver;

    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
    }

    By OrderIdLink = By.cssSelector("th:nth-child(2) div:nth-child(1) input:nth-child(1)");
    By FromLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");
    By ToLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");
    By SearchLink = By.cssSelector("button[title='Search'] span span span");


    public void enterOrderIdLink(String OrderId) {
        WebElement element = driver.findElement(OrderIdLink);
        element.clear();
        element.sendKeys(OrderId);
    }

    public void enterFromLink(String From) {
        WebElement element = driver.findElement(FromLink);
        element.clear();
        element.sendKeys(From);
    }

    public void enterToLink(String To) {
        WebElement element = driver.findElement(ToLink);
        element.clear();
        element.sendKeys(To);
    }

    public void clickSearchLink() {
        driver.findElement(SearchLink).click();
    }



}
