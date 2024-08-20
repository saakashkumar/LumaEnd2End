package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainStepDefinition {

    public String browserType = "chrome";
    public WebDriver driver = DriverFactory.selectBrowser(browserType);


    @Given("{string} is at Singup page of Luma")
    public void is_at_singup_page_of_luma(String string) {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();

    }
    @When("User enters all the details and Clicked on Create account buttom")
    public void user_enters_all_the_details_and_clicked_on_create_account_buttom() {
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Aakash");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Singh");
        driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("aaakashkumar@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123@ABCxyz");
        driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("123@ABCxyz");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();

    }
    @Then("User's account get created and message displayed.")
    public void user_s_account_get_created_and_message_displayed() {

        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
        String pageTitle= driver.getTitle();
        if (pageTitle == "My Account"){
            System.out.println("User have successfully logged in");
        }
        else
            System.out.println("Test Failed");

    }

}
