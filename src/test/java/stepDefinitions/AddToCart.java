package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AddToCartElements;
import utils.Elements;

public class AddToCart {

    public static String browserType = "chrome";
    public static WebDriver driver = DriverFactory.selectBrowser(browserType);
    private AddToCartElements elements = new AddToCartElements(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 10); // 10-second wait time

    @Given("User is at login page")
    public void user_is_at_login_page() {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Sign In")).click();
        System.out.println(driver.getTitle());
    }


    @When("User enter username and password and click on submit")
    public void user_enter_username_and_password_and_click_on_submit() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saakashkumar@gmail.com");
        driver.findElement(By.xpath("//*[@id = \"pass\"]")).sendKeys("123@ABCxyz");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
        String userName= driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        System.out.println("User has logged in successfully and name:- "+ userName + " displayed");
    }
    @Then("Home page is opened and search box is open")
    public void home_page_is_opened_and_search_box_is_open() {

    }
}
