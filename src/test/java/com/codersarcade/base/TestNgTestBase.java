package com.codersarcade.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestNgTestBase {
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        capabilities = config.getCapabilities();
    }

    @BeforeMethod
    public void initWebDriver() {
        switch (capabilities.getBrowserName()){

            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options1 = new FirefoxOptions();
                options1.merge(capabilities);
                driver = new FirefoxDriver(options1);
                break;

            case "chrome_headless" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions options3 = new ChromeOptions();
                options3.addArguments("headless");
                options3.merge(capabilities);
                driver = new ChromeDriver(options3);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                break;

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options2 = new ChromeOptions();
                options2.merge(capabilities);
                driver = new ChromeDriver(options2);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    /*@AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }*/

}
