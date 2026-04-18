package com.portfolio.pages;

import org.openqa.selenium.*;
import java.util.List;
import java.util.Map;

public class ContactPage extends BasePage {

    private static final By CONTACT_SECTION = By.id("contact");
    private static final By SECTION_TITLE   = By.cssSelector("#contact .section-title");
    private static final By CONTACT_LINKS   = By.cssSelector("#contact .contact-link");
    private static final By CONTACT_FORM    = By.cssSelector("#contact .contact-form");
    private static final By SUBMIT_BUTTON   = By.cssSelector("#contact .contact-form button[type='submit']");

    public ContactPage(WebDriver driver) { super(driver); }

    public boolean isContactVisible()       { return isElementVisible(CONTACT_SECTION); }
    public String  getSectionTitle()        { return waitForVisible(SECTION_TITLE).getText().trim(); }
    public boolean isFormVisible()          { return isElementVisible(CONTACT_FORM); }
    public List<WebElement> getContactLinks(){ return driver.findElements(CONTACT_LINKS); }

    public WebElement getLinkByLabel(String label) {
        return getContactLinks().stream()
                .filter(l -> l.getText().contains(label))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact link not found: " + label));
    }

    public boolean hasLinkWithLabel(String label) {
        return getContactLinks().stream()
                .anyMatch(l -> l.getText().contains(label));
    }

    public String getLinkHref(String label) {
        return getAttributeOrEmpty(getLinkByLabel(label), "href");
    }

    public String getLinkTarget(String label) {
        return getAttributeOrEmpty(getLinkByLabel(label), "target");
    }

    public WebElement getField(String id)   { return driver.findElement(By.id(id)); }
    public boolean hasField(String id)      { return isElementPresent(By.id(id)); }

    public boolean isFieldRequired(String id) {
        return Boolean.parseBoolean(getAttributeOrEmpty(getField(id), "required"))
                || "true".equals(getAttributeOrEmpty(getField(id), "required"))
                || getAttributeOrEmpty(getField(id), "required").isEmpty() == false
                        && getField(id).getAttribute("required") != null;
    }

    public String getFieldPlaceholder(String id) {
        return getAttributeOrEmpty(getField(id), "placeholder");
    }

    public void fillField(String id, String value) {
        WebElement field = waitForVisible(By.id(id));
        field.clear();
        field.sendKeys(value);
    }

    public void fillForm(Map<String, String> data) {
        data.forEach(this::fillField);
    }

    public boolean allFieldsFilled(List<String> fieldIds) {
        return fieldIds.stream().allMatch(id -> {
            String val = getField(id).getAttribute("value");
            return val != null && !val.isBlank();
        });
    }

    public WebElement getSubmitButton()     { return waitForVisible(SUBMIT_BUTTON); }
    public String  getSubmitButtonText()    { return getSubmitButton().getText().trim(); }

    public void clickSubmit()               { waitForClickable(SUBMIT_BUTTON).click(); }

    public boolean isEmailFieldInvalid() {
        return (boolean) js.executeScript(
            "return !document.getElementById('email').checkValidity();");
    }

    public boolean isSubmitButtonDisabled() {
        return !getSubmitButton().isEnabled() ||
               Boolean.parseBoolean(getAttributeOrEmpty(getSubmitButton(), "disabled"));
    }
}
