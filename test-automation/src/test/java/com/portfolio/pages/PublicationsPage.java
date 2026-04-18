package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;

public class PublicationsPage extends BasePage {

    private static final By PUB_SECTION   = By.id("publications");
    private static final By SECTION_TITLE = By.cssSelector("#publications .section-title");
    private static final By PUB_CARDS     = By.cssSelector("#publications .pub-card");

    public PublicationsPage(WebDriver driver) { super(driver); }

    public boolean isPublicationsVisible()      { return isElementVisible(PUB_SECTION); }
    public String  getSectionTitle()            { return waitForVisible(SECTION_TITLE).getText().trim(); }
    public List<WebElement> getPublicationCards(){ return driver.findElements(PUB_CARDS); }

    public WebElement getCardByIndex(int zeroBasedIndex) {
        List<WebElement> cards = getPublicationCards();
        if (zeroBasedIndex >= cards.size())
            throw new NoSuchElementException("Publication card index " + zeroBasedIndex + " not found");
        return cards.get(zeroBasedIndex);
    }

    public String getCardText(int index)        { return getCardByIndex(index).getText().trim(); }
    public boolean cardContains(int index, String text) { return getCardText(index).contains(text); }

    public boolean cardHasJournal(int index) {
        WebElement card = getCardByIndex(index);
        try {
            String journal = card.findElement(By.cssSelector(".pub-journal")).getText();
            return journal != null && !journal.isBlank();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
