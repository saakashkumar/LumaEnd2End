package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

    private WebDriver driver;

    // Constructor
    public Elements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCreateAccount() {
        return driver.findElement(By.linkText("Create an Account"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
    }

    public WebElement getEmailID() {
        return driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.xpath("//*[@id=\"password\"]"));
    }

    public WebElement getConfirmPassword() {
        return driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
    }

    public WebElement getConfirmationMessage() {
        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
    }
}
