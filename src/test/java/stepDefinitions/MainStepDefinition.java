package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainStepDefinition {

    public static String browserType = "chrome";
    public static WebDriver driver = DriverFactory.selectBrowser(browserType);


    @Given("{string} is at Singup page of Luma")
    public void is_at_singup_page_of_luma(String string) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
        Elements.CreateAccount.click();
        Thread.sleep(3000);
        driver.getTitle();


    }
    @When("User enters all the details and Clicked on Create account buttom")
    public void user_enters_all_the_details_and_clicked_on_create_account_buttom() throws InterruptedException {
        Elements.FirstName.sendKeys("Aakash");
        Elements.LastName.sendKeys("Singh");
        Elements.EmailID.sendKeys("aaakashkumar@gmail.com");
        Elements.Password.sendKeys("123@ABCxyz");
        Elements.ConfirmPassword.sendKeys("123@ABCxyz");
        Elements.SubmitButton.click();
        Thread.sleep(2000);

    }
    @Then("User's account get created and message displayed.")
    public void user_s_account_get_created_and_message_displayed() {

        Elements.ConfirmationMessage.getText();
        String pageTitle= driver.getTitle();
        if (pageTitle == "My Account"){
            System.out.println("User have successfully logged in");
        }
        else
            System.out.println("Test Failed");

    }

}
