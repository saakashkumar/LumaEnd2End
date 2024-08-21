package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Elements;

public class MainStepDefinition {

    public static String browserType = "chrome";
    public static WebDriver driver = DriverFactory.selectBrowser(browserType);
    private Elements elements = new Elements(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait time

    @Given("User is at Singup page of Luma")
    public void user_is_at_singup_page_of_luma() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        wait.until(ExpectedConditions.elementToBeClickable(elements.getCreateAccount())).click();
    }

    @When("User enters all the details and Clicked on Create account buttom")
    public void user_enters_all_the_details_and_clicked_on_create_account_buttom() {
        elements.getFirstName().sendKeys("Aakash");
        elements.getLastName().sendKeys("Singh");
        elements.getEmailID().sendKeys("asekashkumar@gmail.com");
        elements.getPassword().sendKeys("123@ABCxyz");
        elements.getConfirmPassword().sendKeys("123@ABCxyz");
        wait.until(ExpectedConditions.elementToBeClickable(elements.getSubmitButton())).click();
    }

    @Then("User's account get created and message displayed.")
    public void user_s_account_get_created_and_message_displayed() {

        String pageTitle = driver.getTitle();

        System.out.println("Page Title is:: "+ pageTitle);

        if (pageTitle.equals("My Account")) {
            System.out.println("Test Passed");
            wait.until(ExpectedConditions.visibilityOf(elements.getConfirmationMessage()));
        } else {
            System.out.println("Test Failed");
        }
    }
}
