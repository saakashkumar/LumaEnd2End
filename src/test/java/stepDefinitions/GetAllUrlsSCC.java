package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GetAllUrlsSCC {

    public static String browserType = "chrome";
    public static WebDriver driver = DriverFactory.selectBrowser(browserType);

    @Given("I login at SCC Portal")
    public void i_login_at_SCC_portal() {
        // Initialize WebDriver and open the SCC portal login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://scce.edu.in/student-s-login.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Switch to iframe and perform login
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://www.scce.edu.in/sccelive/header.aspx']")));

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"txt_login_name\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"txt_pwd\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"img_login\"]"));

        usernameField.sendKeys("WNU2302301");
        passwordField.sendKeys("AKS123aa");
        loginButton.click();

        // Get the current window handle (original window)
        String originalWindow = driver.getWindowHandle();

        // Wait for new window/tab to open
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all the window handles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<>(windowHandles);

        // Switch to the new tab (second window handle)
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    @When("Navigate to Handouts")
    public void nevigate_to_handouts() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement handoutsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cssmenu\"]/ul/li[5]/a")));
        handoutsMenu.click();
    }

    @When("Select the {string}")
    public void select_the_semester(String semester) {
        WebElement semesterDropdown = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddl_semister"));
        semesterDropdown.click();

        WebElement selectedSemester = driver.findElement(By.xpath("//option[text()='" + semester + "']"));
        selectedSemester.click();
    }

    @Then("I get all the links for downloads and download files")
    public void i_get_all_the_links_for_downloads() {
        WebElement handoutsTable = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lbl_hndouts']//table"));
        List<WebElement> downloadLinks = handoutsTable.findElements(By.tagName("a"));

        // Iterate over all the found links and download the files
        for (WebElement link : downloadLinks) {
            String href = link.getAttribute("href");
            String linkText = link.getText();

            // Ensure valid file name by replacing invalid characters
            String safeFileName = linkText.replaceAll("[^a-zA-Z0-9\\.\\-]", "_") + ".pdf";

            System.out.println("Link Text: " + safeFileName + " | URL: " + href);

            // Download the file from the link
            try {
                downloadFile(href, safeFileName);
            } catch (IOException e) {
                System.out.println("Error downloading file: " + safeFileName);
                e.printStackTrace();
            }
        }
    }

    // Method to download a file from a URL
    private void downloadFile(String fileUrl, String fileName) throws IOException {
        // Set the download directory path
        String downloadDirPath = "C:/Downloads/Sem4";

        // Create the download directory if it doesn't exist
        File downloadDir = new File(downloadDirPath);
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }

        // Create a URL object
        URL url = new URL(fileUrl);

        // Open a stream to read data from the URL
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(downloadDirPath + fileName)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

            System.out.println("Downloaded: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to download: " + fileName);
            throw e;
        }
    }
}

