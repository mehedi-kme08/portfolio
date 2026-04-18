package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class EducationPage extends BasePage {

    private static final By EDU_SECTION      = By.id("education");
    private static final By SECTION_TITLE    = By.cssSelector("#education .section-title");
    private static final By EDU_CARDS        = By.cssSelector("#education .edu-card");
    private static final By HIGHLIGHT_CARDS  = By.cssSelector("#education .highlight-card");

    public EducationPage(WebDriver driver) { super(driver); }

    public boolean isEducationVisible()         { return isElementVisible(EDU_SECTION); }
    public String  getSectionTitle()            { return waitForVisible(SECTION_TITLE).getText().trim(); }
    public List<WebElement> getEduCards()       { return driver.findElements(EDU_CARDS); }
    public List<WebElement> getCredentialCards(){ return driver.findElements(HIGHLIGHT_CARDS); }

    public boolean hasEduCardContaining(String keyword) {
        return getEduCards().stream()
                .anyMatch(c -> c.getText().contains(keyword));
    }

    public boolean hasCredentialContaining(String keyword) {
        return getCredentialCards().stream()
                .anyMatch(c -> c.getText().contains(keyword));
    }
}
