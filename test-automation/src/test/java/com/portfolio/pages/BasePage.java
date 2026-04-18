package com.portfolio.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.portfolio.config.ConfigReader;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final JavascriptExecutor js;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
        this.js     = (JavascriptExecutor) driver;
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitForAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /** Smooth-scrolls an element to the centre of the viewport. */
    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({behavior:'instant',block:'center'});", element);
        pause(400);
    }

    /** Scrolls the page to a section by its HTML id. */
    public void scrollToSection(String sectionId) {
        js.executeScript(
            "var el = document.getElementById(arguments[0]);" +
            "if(el) el.scrollIntoView({behavior:'instant',block:'start'});", sectionId);
        pause(700);
    }

    /** Scrolls to the very bottom of the page. */
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(700);
    }

    /** Returns true when the element's top edge is within the viewport. */
    protected boolean isInViewport(WebElement element) {
        Long top = (Long) js.executeScript(
            "var rect = arguments[0].getBoundingClientRect();" +
            "return rect.top;", element);
        Long vh = (Long) js.executeScript("return window.innerHeight;");
        return top != null && vh != null && top >= 0 && top <= vh;
    }

    protected String getAttributeOrEmpty(WebElement el, String attr) {
        String val = el.getAttribute(attr);
        return val != null ? val : "";
    }

    protected void pause(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
