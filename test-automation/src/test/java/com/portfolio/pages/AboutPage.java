package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class AboutPage extends BasePage {

    private static final By ABOUT_SECTION   = By.id("about");
    private static final By SECTION_LABEL   = By.cssSelector("#about .section-label");
    private static final By SECTION_TITLE   = By.cssSelector("#about .section-title");
    private static final By ABOUT_TEXTS     = By.cssSelector("#about .about-text p");
    private static final By HIGHLIGHT_CARDS = By.cssSelector("#about .highlight-card");

    public AboutPage(WebDriver driver) { super(driver); }

    public boolean isAboutVisible()         { return isElementVisible(ABOUT_SECTION); }
    public String  getSectionLabel()        { return waitForVisible(SECTION_LABEL).getText().trim(); }
    public String  getSectionTitle()        { return waitForVisible(SECTION_TITLE).getText().trim(); }

    public List<WebElement> getAboutTexts()      { return driver.findElements(ABOUT_TEXTS); }
    public List<WebElement> getHighlightCards()  { return driver.findElements(HIGHLIGHT_CARDS); }

    public boolean aboutTextContains(String keyword) {
        return getAboutTexts().stream()
                .anyMatch(p -> p.getText().contains(keyword));
    }

    public boolean hasHighlightCardWithTitle(String title) {
        return getHighlightCards().stream()
                .anyMatch(c -> c.getText().contains(title));
    }
}
