package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class ExperiencePage extends BasePage {

    private static final By EXP_SECTION    = By.id("experience");
    private static final By SECTION_TITLE  = By.cssSelector("#experience .section-title");
    private static final By TIMELINE_ITEMS = By.cssSelector("#experience .tl-item");

    public ExperiencePage(WebDriver driver) { super(driver); }

    public boolean isExperienceVisible()      { return isElementVisible(EXP_SECTION); }
    public String  getSectionTitle()          { return waitForVisible(SECTION_TITLE).getText().trim(); }
    public List<WebElement> getTimelineItems(){ return driver.findElements(TIMELINE_ITEMS); }

    /** Use JS textContent so opacity-0 (pre-animation) items are still readable. */
    private String itemTextContent(WebElement item) {
        Object result = js.executeScript("return arguments[0].textContent;", item);
        return result != null ? result.toString() : "";
    }

    public boolean hasItemWithRole(String roleText) {
        return getTimelineItems().stream()
                .anyMatch(item -> itemTextContent(item).contains(roleText));
    }

    public WebElement getFirstItem() {
        List<WebElement> items = getTimelineItems();
        if (items.isEmpty()) throw new NoSuchElementException("No timeline items found");
        return items.get(0);
    }

    public boolean firstItemHasStatusBadge(String badgeText) {
        return itemTextContent(getFirstItem()).contains(badgeText);
    }

    public String getFirstItemDateText() {
        WebElement first = getFirstItem();
        try {
            // Use JS for period too — it may still be opacity:0
            Object result = js.executeScript(
                "var el = arguments[0].querySelector('.tl-period'); return el ? el.textContent : null;",
                first);
            return result != null ? result.toString().trim() : itemTextContent(first);
        } catch (Exception e) {
            return itemTextContent(first);
        }
    }

    public boolean firstItemBulletsContain(String keyword) {
        // Scroll first item into view so animation fires, then read
        WebElement first = getFirstItem();
        scrollToElement(first);
        pause(600);
        List<WebElement> bullets = first.findElements(By.tagName("li"));
        return bullets.stream().anyMatch(b -> {
            Object text = js.executeScript("return arguments[0].textContent;", b);
            return text != null && text.toString().contains(keyword);
        });
    }

    /** Checks whether ANY timeline item's full text contains the given string. */
    public boolean anyItemContains(String text) {
        return getTimelineItems().stream()
                .anyMatch(item -> itemTextContent(item).contains(text));
    }

    public boolean eachItemHasBullets() {
        return getTimelineItems().stream().allMatch(item -> {
            List<WebElement> bullets = item.findElements(By.tagName("li"));
            return !bullets.isEmpty();
        });
    }
}
