package com.tradingview.screener.e2e.config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners({AllureTestListener.class})
public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();;

    public final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
            WebDriver webDriver = null;
            switch (Configuration.browser) {
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("--headless=new");
                    options.addArguments("--start-maximized");
                    options.addArguments("--no-sandbox");
                    webDriver = new ChromeDriver(options);
                    break;
                case "firefox" :
                    System.out.println("2");
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().maximize();
                    break;
            }
            driver.set(webDriver);
            setWebDriver(driver.get());

    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public WebDriver getDriver() {
        try {
            if (driver == null) {
                logger.error("WebDriver was not be initialize.");
                throw new IllegalStateException("WebDriver is not initialized.");
            }
            return driver.get();
        } catch (Exception ex) {
            logger.error("Exception occurred while getting WebDriver: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to get WebDriver", ex);
        }
    }
}
