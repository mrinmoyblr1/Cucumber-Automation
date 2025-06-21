package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/test/java/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        if (driver == null) {
            if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                System.setProperty("webdriver.chome.driver", System.getProperty("user.dir") + "//src/test/java/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            driver.get(url);
        }
        return driver;
    }
}
