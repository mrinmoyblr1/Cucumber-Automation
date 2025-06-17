package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features"
        , glue = "stepDefinations"
        , tags = "@RegressionTest1"
        //, tags = "@SmokeTest or @RegressionTest"
        //, tags = "@SmokeTest and @RegressionTest"
        // , tags = "not @RegressionTest"
        , plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml"}
)


public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
