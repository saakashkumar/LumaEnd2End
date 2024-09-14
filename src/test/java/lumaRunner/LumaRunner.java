package lumaRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = "src/test/java/features",
        glue = "stepDefinitions",

        monochrome = true,
        tags = "@SCC",
        plugin = {
          "pretty", // Pretty console output
          "html:target/cucumber-reports.html",
          "json:target/cucumber.json"}

        )

public class LumaRunner extends AbstractTestNGCucumberTests {
}
