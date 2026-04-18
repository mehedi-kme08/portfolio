package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.ContactPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactStepDefs {

    private ContactPage contactPage() {
        return new ContactPage(DriverManager.getDriver());
    }

    @Then("the contact section should be visible")
    public void contactVisible() {
        assertThat(contactPage().isContactVisible()).isTrue();
    }

    @Then("the contact section title should contain {string}")
    public void contactSectionTitle(String expected) {
        assertThat(contactPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("a contact link with label {string} should exist")
    public void contactLinkWithLabel(String label) {
        assertThat(contactPage().hasLinkWithLabel(label))
                .as("Expected contact link: " + label)
                .isTrue();
    }

    @Then("the email contact link href should be {string}")
    public void emailContactHref(String expected) {
        assertThat(contactPage().getLinkHref("Email")).isEqualTo(expected);
    }

    @Then("the phone contact link href should be {string}")
    public void phoneContactHref(String expected) {
        assertThat(contactPage().getLinkHref("Phone")).isEqualTo(expected);
    }

    @Then("the LinkedIn contact link href should contain {string}")
    public void linkedInContactHref(String partial) {
        assertThat(contactPage().getLinkHref("LinkedIn")).contains(partial);
    }

    @Then("the LinkedIn contact link should have target {string}")
    public void linkedInContactTarget(String expected) {
        assertThat(contactPage().getLinkTarget("LinkedIn")).isEqualTo(expected);
    }

    @Then("the contact form should be visible")
    public void contactFormVisible() {
        assertThat(contactPage().isFormVisible()).isTrue();
    }

    @Then("the contact form should have an input field with id {string}")
    public void formHasInputField(String id) {
        assertThat(contactPage().hasField(id))
                .as("Expected form field: #" + id)
                .isTrue();
    }

    @Then("the contact form should have a textarea with id {string}")
    public void formHasTextarea(String id) {
        assertThat(contactPage().hasField(id))
                .as("Expected textarea: #" + id)
                .isTrue();
    }

    @Then("the contact form submit button should have text {string}")
    public void submitButtonText(String expected) {
        assertThat(contactPage().getSubmitButtonText()).contains(expected);
    }

    @Then("the {string} field placeholder should be {string}")
    public void fieldPlaceholder(String id, String expected) {
        assertThat(contactPage().getFieldPlaceholder(id)).isEqualTo(expected);
    }

    @Then("the {string} field placeholder should contain {string}")
    public void fieldPlaceholderContains(String id, String partial) {
        assertThat(contactPage().getFieldPlaceholder(id)).contains(partial);
    }

    @Then("the {string} input should be marked as required")
    public void inputIsRequired(String id) {
        assertThat(contactPage().getField(id).getAttribute("required"))
                .as("Field #" + id + " should be required")
                .isNotNull();
    }

    @Then("the {string} textarea should be marked as required")
    public void textareaIsRequired(String id) {
        assertThat(contactPage().getField(id).getAttribute("required"))
                .as("Textarea #" + id + " should be required")
                .isNotNull();
    }

    @Then("the {string} input should not be marked as required")
    public void inputIsNotRequired(String id) {
        String req = contactPage().getField(id).getAttribute("required");
        assertThat(req == null || req.isEmpty())
                .as("Field #" + id + " should NOT be required")
                .isTrue();
    }

    @When("I fill in the contact form with:")
    public void fillContactForm(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        contactPage().fillForm(data);
    }

    @Then("all contact form fields should be filled")
    public void allFieldsFilled() {
        List<String> fields = Arrays.asList("fname", "lname", "email", "subject", "message");
        assertThat(contactPage().allFieldsFilled(fields)).isTrue();
    }

    @When("I enter {string} in the {string} field")
    public void enterValueInField(String value, String id) {
        contactPage().fillField(id, value);
    }

    @When("I click the contact form submit button")
    public void clickSubmit() {
        contactPage().clickSubmit();
    }

    @Then("the browser should flag the email field as invalid")
    public void emailFieldIsInvalid() {
        assertThat(contactPage().isEmailFieldInvalid()).isTrue();
    }

    @Then("the submit button text should change from {string}")
    public void submitButtonTextChanged(String original) {
        try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        String currentText = contactPage().getSubmitButtonText();
        boolean changed = !currentText.contains(original) || contactPage().isSubmitButtonDisabled();
        assertThat(changed)
                .as("Submit button should have changed state from: " + original)
                .isTrue();
    }
}
