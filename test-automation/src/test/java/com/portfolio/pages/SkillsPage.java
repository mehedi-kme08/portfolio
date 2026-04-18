package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class SkillsPage extends BasePage {

    private static final By SKILLS_SECTION   = By.id("skills");
    private static final By SECTION_LABEL    = By.cssSelector("#skills .section-label");
    private static final By SKILL_CATEGORIES = By.cssSelector("#skills .skill-category");
    private static final By SKILL_BAR_ITEMS  = By.cssSelector("#skills .skill-bar-item");
    private static final By SKILL_TAGS       = By.cssSelector("#skills .skill-tag");

    public SkillsPage(WebDriver driver) { super(driver); }

    public boolean isSkillsVisible()          { return isElementVisible(SKILLS_SECTION); }
    public boolean isSectionLabelVisible()    { return isElementVisible(SECTION_LABEL); }
    public List<WebElement> getCategories()   { return driver.findElements(SKILL_CATEGORIES); }
    public List<WebElement> getSkillBars()    { return driver.findElements(SKILL_BAR_ITEMS); }
    public List<WebElement> getSkillTags()    { return driver.findElements(SKILL_TAGS); }

    public boolean hasCategoryContaining(String text) {
        return getCategories().stream()
                .anyMatch(c -> c.getText().contains(text));
    }

    public boolean hasSkillBarFor(String name) {
        return getSkillBars().stream()
                .anyMatch(b -> b.getText().contains(name));
    }

    public boolean hasSkillTag(String tagName) {
        return getSkillTags().stream()
                .anyMatch(t -> t.getText().trim().equalsIgnoreCase(tagName));
    }
}
