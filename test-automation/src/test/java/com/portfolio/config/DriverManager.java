package com.portfolio.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (driverHolder.get() == null) {
            initDriver();
        }
        return driverHolder.get();
    }

    public static void initDriver() {
        String browser  = ConfigReader.getBrowser();
        boolean headless = ConfigReader.isHeadless();
        WebDriver driver;

        switch (browser.trim().toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOpts = new FirefoxOptions();
                if (headless) ffOpts.addArguments("-headless");
                driver = new FirefoxDriver(ffOpts);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOpts = new EdgeOptions();
                if (headless) edgeOpts.addArguments("--headless=new");
                edgeOpts.addArguments("--window-size=1920,1080", "--no-sandbox",
                        "--disable-dev-shm-usage");
                driver = new EdgeDriver(edgeOpts);
                break;

            default: // chrome
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOpts = new ChromeOptions();
                if (headless) chromeOpts.addArguments("--headless=new");
                chromeOpts.addArguments("--window-size=1920,1080", "--no-sandbox",
                        "--disable-dev-shm-usage", "--disable-gpu");
                driver = new ChromeDriver(chromeOpts);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()))
                .pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));

        driverHolder.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = driverHolder.get();
        if (driver != null) {
            driver.quit();
            driverHolder.remove();
        }
    }
}
