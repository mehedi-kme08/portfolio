package com.portfolio.stepdefs;

import com.portfolio.config.ConfigReader;
import com.portfolio.config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.initDriver();
        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigReader.getBaseUrl());
        // Allow time for the SPA and canvas animation to initialise
        try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        // Force all intersection-observer-driven elements visible — the IO does not
        // fire reliably in headless Chrome, leaving elements at opacity:0 which
        // makes isDisplayed() return false and getText() return "".
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('.fade-in,.tl-item,.ach-card,.pub-card')" +
            ".forEach(function(el){ el.classList.add('visible'); });"
        );
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null && scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure-screenshot-" + scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
