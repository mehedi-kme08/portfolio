package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class NavigationPage extends BasePage {

    private static final By NAV            = By.id("nav");
    private static final By NAV_LOGO_TEXT  = By.cssSelector(".nav-logo-text");
    private static final By NAV_LOGO_LINK  = By.cssSelector(".nav-logo");
    private static final By NAV_LINKS      = By.cssSelector("#nav-links a");
    private static final By NAV_CTA        = By.cssSelector(".nav-cta");
    private static final By HAMBURGER      = By.id("hamburger");

    public NavigationPage(WebDriver driver) { super(driver); }

    public boolean isNavVisible()           { return isElementVisible(NAV); }
    public String  getLogoText()            { return waitForVisible(NAV_LOGO_TEXT).getText().trim(); }

    public List<WebElement> getNavLinks()   { return driver.findElements(NAV_LINKS); }

    public boolean hasNavLinkWithText(String text) {
        return getNavLinks().stream()
                .anyMatch(a -> a.getText().trim().equalsIgnoreCase(text));
    }

    public WebElement getNavLinkByText(String text) {
        return getNavLinks().stream()
                .filter(a -> a.getText().trim().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Nav link not found: " + text));
    }

    public void clickNavLinkByText(String text) {
        WebElement link = getNavLinkByText(text);
        scrollToElement(link);
        link.click();
        pause(1600);
    }

    public boolean hasCTAButton()           { return isElementPresent(NAV_CTA); }
    public String  getCTAText()             { return waitForVisible(NAV_CTA).getText().trim(); }

    public void clickCTA() {
        waitForClickable(NAV_CTA).click();
        pause(1600);
    }

    public void clickLogo() {
        waitForClickable(NAV_LOGO_LINK).click();
        pause(1600);
    }

    public boolean isHamburgerVisible()     { return isElementVisible(HAMBURGER); }
}
