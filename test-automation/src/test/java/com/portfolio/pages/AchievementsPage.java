package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class AchievementsPage extends BasePage {

    private static final By ACH_SECTION   = By.id("achievements");
    private static final By SECTION_TITLE = By.cssSelector("#achievements .section-title");
    private static final By ACH_CARDS     = By.cssSelector("#achievements .ach-card");

    public AchievementsPage(WebDriver driver) { super(driver); }

    public boolean isAchievementsVisible()       { return isElementVisible(ACH_SECTION); }
    public String  getSectionTitle()             { return waitForVisible(SECTION_TITLE).getText().trim(); }
    public List<WebElement> getAchievementCards(){ return driver.findElements(ACH_CARDS); }

    public boolean hasCardContaining(String text) {
        return getAchievementCards().stream()
                .anyMatch(c -> c.getText().contains(text));
    }
}
