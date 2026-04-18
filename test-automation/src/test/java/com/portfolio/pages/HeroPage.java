package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class HeroPage extends BasePage {

    private static final By HERO_SECTION  = By.id("hero");
    private static final By HERO_BADGE    = By.cssSelector(".hero-badge");
    private static final By HERO_NAME     = By.cssSelector(".hero-name");
    private static final By TYPED_TEXT    = By.id("typed-text");
    private static final By HERO_ACTIONS  = By.cssSelector(".hero-actions");
    private static final By HERO_BTNS     = By.cssSelector(".hero-actions .btn");
    private static final By HERO_STATS    = By.cssSelector(".hero-stats");
    private static final By STAT_ITEMS    = By.cssSelector(".hero-stats [role='listitem']");

    public HeroPage(WebDriver driver) { super(driver); }

    public boolean isHeroVisible()         { return isElementVisible(HERO_SECTION); }
    public boolean isBadgeVisible()        { return isElementVisible(HERO_BADGE); }
    public String  getBadgeText()          { return waitForVisible(HERO_BADGE).getText().trim(); }
    public String  getHeroNameText()       { return waitForVisible(HERO_NAME).getText().trim(); }
    public boolean isTypedTextPresent()    { return isElementPresent(TYPED_TEXT); }
    public boolean isStatsVisible()        { return isElementVisible(HERO_STATS); }

    public WebElement getButtonByText(String text) {
        return driver.findElements(HERO_BTNS).stream()
                .filter(b -> b.getText().trim().contains(text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Hero button not found: " + text));
    }

    public boolean hasButtonWithText(String text) {
        return driver.findElements(HERO_BTNS).stream()
                .anyMatch(b -> b.getText().trim().contains(text));
    }

    public String getButtonHref(String text)  { return getAttributeOrEmpty(getButtonByText(text), "href"); }
    public String getButtonTarget(String text) { return getAttributeOrEmpty(getButtonByText(text), "target"); }

    public List<WebElement> getStatItems()  { return driver.findElements(STAT_ITEMS); }
    public boolean hasStatContaining(String text) {
        return getStatItems().stream()
                .anyMatch(s -> s.getText().contains(text));
    }

    public long getHeroSectionHeight() {
        WebElement hero = driver.findElement(HERO_SECTION);
        return (Long) js.executeScript("return arguments[0].offsetHeight;", hero);
    }

    public long getViewportHeight() {
        return (Long) js.executeScript("return window.innerHeight;");
    }
}
