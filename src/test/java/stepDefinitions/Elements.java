package stepDefinitions;

import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements {

    static WebElement CreateAccount = MainStepDefinition.driver.findElement(By.linkText("Create an Account"));

    static WebElement FirstName= MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"firstname\"]"));

    static WebElement LastName = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"lastname\"]"));

    static WebElement EmailID = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"email_address\"]"));

    static WebElement Password = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"password\"]"));

    static WebElement ConfirmPassword = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));

    static WebElement SubmitButton = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));

    static WebElement ConfirmationMessage = MainStepDefinition.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));


}
