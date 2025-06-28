package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/failed_scenarios.txt"
        //, dryRun = true   // dryRun = true. This is just like compile. It will check if all the lines under features file has respected step definition or not !
        , glue = "stepDefinitions"
        , tags = "@PlaceOrder or @OffersPage"
//        , tags = "@OffersPage"
        //, tags = "@SmokeTest and @RegressionTest"
        // , tags = "not @RegressionTest"
        //,monochrome = true  // This will make the test output more readable, without it there will be some alphanumeric values
        , plugin = {"pretty", "html:target/cucumber.html"
        , "json:target/cucumber.json"
        , "junit:target/cukes.xml"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}

)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
