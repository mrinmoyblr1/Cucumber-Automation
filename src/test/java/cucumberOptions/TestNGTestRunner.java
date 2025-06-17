package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features"
        //, dryRun = true   // dryRun = true. This is just like compile. It will check if all the lines under features file has respected step definition or not !
        , glue = "stepDefinations"
        //, tags = "@RegressionTest1"
        //, tags = "@SmokeTest or @RegressionTest"
        //, tags = "@SmokeTest and @RegressionTest"
        // , tags = "not @RegressionTest"
        //,monochrome = true  // This will make the test output more readable, without it there will be some alphanumeric values
        , plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml"}
)


public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
