package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
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

    }


}
