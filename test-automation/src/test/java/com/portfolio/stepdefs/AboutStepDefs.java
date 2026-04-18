package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.AboutPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AboutStepDefs {

    private AboutPage aboutPage() {
        return new AboutPage(DriverManager.getDriver());
    }

    @Then("the about section should be visible")
    public void aboutVisible() {
        assertThat(aboutPage().isAboutVisible()).isTrue();
    }

    @Then("the about section label should be {string}")
    public void aboutSectionLabel(String expected) {
        assertThat(aboutPage().getSectionLabel()).isEqualToIgnoringCase(expected);
    }

    @Then("the about section title should contain {string}")
    public void aboutSectionTitleContains(String expected) {
        assertThat(aboutPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("the about section should have at least {int} text paragraphs")
    public void aboutTextParagraphs(int minCount) {
        assertThat(aboutPage().getAboutTexts().size()).isGreaterThanOrEqualTo(minCount);
    }

    @Then("the about text should mention {string}")
    public void aboutTextMentions(String keyword) {
        assertThat(aboutPage().aboutTextContains(keyword))
                .as("About text should mention: " + keyword)
                .isTrue();
    }

    @Then("the about section should display {int} highlight cards")
    public void aboutHighlightCardCount(int expected) {
        assertThat(aboutPage().getHighlightCards().size()).isEqualTo(expected);
    }

    @Then("an about highlight card with title {string} should exist")
    public void aboutHighlightCardWithTitle(String title) {
        assertThat(aboutPage().hasHighlightCardWithTitle(title))
                .as("Expected highlight card: " + title)
                .isTrue();
    }
}
