package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public static WebDriver selectBrowser(String BrowserType) {

        if (BrowserType.equalsIgnoreCase("chrome"))
            System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing\\LUMA\\LumaEnd2End\\src\\drivers\\chromedriver.exe");
        return new ChromeDriver();

//        else if(BrowserType.equalsIgnoreCase("firefox") ) {
//            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//            return new FirefoxDriver();
//        }

    }
}