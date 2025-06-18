package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() {

        if (driver == null) {
            System.setProperty("webdriver.chome.driver", "/Users/mrinmoy/Documents/Development/Selenium/chromedriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        }
        return driver;
    }
}
