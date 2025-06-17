package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;


    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in the offer page")
    public void user_searched_for_same_shortname_in_the_offer_page_to_check_if_product_is_exist(String shortName) throws Throwable {

        switchToOffersPage();
        testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
        offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();  // this css is very important
        System.out.println("The Product Name is extracted from Offer Page: " + offerPageProductName);
        Thread.sleep(5000);
    }


    public void switchToOffersPage() throws Throwable {

        // If  already switched to Offer Page -> Skip below Part
        //if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        testContextSetup.driver.switchTo().window(childWindow);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @And("^validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {

        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
