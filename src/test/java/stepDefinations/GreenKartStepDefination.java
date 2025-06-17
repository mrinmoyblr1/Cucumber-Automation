package stepDefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GreenKartStepDefination {
    public WebDriver driver;

    @Given("^User is on GreenCart landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
        System.setProperty("webdriver.chome.driver", "/Users/mrinmoy/Documents/Development/Selenium/chromedriver");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.close();
    }

    @When("User searched with shortname {} and extracted the actual name of the Product")
    public void userSearchedWithShortnameAndExtractedTheActualNameOfTheProduct(String shortName) throws Throwable {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Tom");
        Thread.sleep(5000);
        String productName = driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
        System.out.println("The Product Name is extracted from Home Page: " + productName);
    }

    @Then("User searched for {} shortname in the offer page to check if product is exist with same name")
    public void user_searched_for_same_shortname_in_the_offer_page_to_check_if_product_is_exist(String shortName) throws Throwable {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);


        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Tom");


    }


    @And("^validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {

    }


}
