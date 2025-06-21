package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("^User is on GreenCart landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
        System.out.println("Browser opened successfully...");
    }

    @When("User searched with shortname {string} and extracted the actual name of the Product")
    public void userSearchedWithShortnameAndExtractedTheActualNameOfTheProduct(String shortName) throws Throwable {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        Thread.sleep(5000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("The Product Name is extracted from Home Page: " + testContextSetup.landingPageProductName);
    }
}
