package stepDefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GreenKartStepDefination {
    public WebDriver driver;
    public String landingPageproductName;
    public String offerPageProductName;

    @Given("^User is on GreenCart landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
        System.setProperty("webdriver.chome.driver", "/Users/mrinmoy/Documents/Development/Selenium/chromedriver");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.close();
    }

    @When("User searched with shortname {string} and extracted the actual name of the Product")
    public void userSearchedWithShortnameAndExtractedTheActualNameOfTheProduct(String shortName) throws Throwable {

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(5000);
        landingPageproductName = driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
        System.out.println("The Product Name is extracted from Home Page: " + landingPageproductName);
        System.out.println("=====");
    }

    @Then("User searched for {string} shortname in the offer page")
    public void user_searched_for_same_shortname_in_the_offer_page_to_check_if_product_is_exist(String shortName) throws Throwable {

        driver.findElement(By.linkText("Top Deals")).click();

        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();  // this css is very important
        System.out.println("The Product Name is extracted from Offer Page: " + offerPageProductName);
        Thread.sleep(5000);

    }


    @And("^validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {

        Assert.assertEquals(offerPageProductName, landingPageproductName);


    }


}
