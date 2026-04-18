package com.portfolio.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class FooterPage extends BasePage {

    // Try id first; fall back to the <footer> tag itself
    private static final By FOOTER       = By.cssSelector("#footer, footer");
    private static final By FOOTER_LINKS = By.cssSelector("#footer a, footer a");

    public FooterPage(WebDriver driver) { super(driver); }

    public boolean isFooterVisible() {
        try {
            WebElement el = driver.findElement(FOOTER);
            scrollToElement(el);
            return el.isDisplayed();
        } catch (NoSuchElementException e) { return false; }
    }

    public String getFooterText() {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(FOOTER));
        scrollToElement(el);
        return el.getText().trim();
    }
    public List<WebElement> getFooterLinks(){ return driver.findElements(FOOTER_LINKS); }

    public boolean hasLinkWithHref(String href) {
        return getFooterLinks().stream()
                .anyMatch(a -> getAttributeOrEmpty(a, "href").contains(href));
    }

    public boolean linkedInOpensInNewTab() {
        return getFooterLinks().stream()
                .filter(a -> getAttributeOrEmpty(a, "href").contains("linkedin.com"))
                .anyMatch(a -> "_blank".equals(getAttributeOrEmpty(a, "target")));
    }
}
