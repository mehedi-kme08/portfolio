package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.EducationPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class EducationStepDefs {

    private EducationPage eduPage() {
        return new EducationPage(DriverManager.getDriver());
    }

    @Then("the education section should be visible")
    public void educationVisible() {
        assertThat(eduPage().isEducationVisible()).isTrue();
    }

    @Then("the education section title should contain {string}")
    public void educationSectionTitle(String expected) {
        assertThat(eduPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("an education card for {string} should exist")
    public void educationCardFor(String degree) {
        assertThat(eduPage().hasEduCardContaining(degree))
                .as("Expected education card for: " + degree)
                .isTrue();
    }

    @Then("the Masters degree card should mention {string}")
    public void mastersDegreeCardMentions(String keyword) {
        assertThat(eduPage().hasEduCardContaining(keyword))
                .as("Masters degree card should mention: " + keyword)
                .isTrue();
    }

    @Then("the Bachelors degree card should mention {string}")
    public void bachelorsDegreeCardMentions(String keyword) {
        assertThat(eduPage().hasEduCardContaining(keyword))
                .as("Bachelors degree card should mention: " + keyword)
                .isTrue();
    }

    @Then("a credential card containing {string} should exist")
    public void credentialCardContaining(String keyword) {
        assertThat(eduPage().hasCredentialContaining(keyword))
                .as("Expected credential card: " + keyword)
                .isTrue();
    }
}
