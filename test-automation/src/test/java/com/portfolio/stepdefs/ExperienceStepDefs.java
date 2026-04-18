package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.ExperiencePage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ExperienceStepDefs {

    private ExperiencePage expPage() {
        return new ExperiencePage(DriverManager.getDriver());
    }

    @Then("the experience section should be visible")
    public void experienceVisible() {
        assertThat(expPage().isExperienceVisible()).isTrue();
    }

    @Then("the experience section title should contain {string}")
    public void expSectionTitle(String expected) {
        assertThat(expPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("the experience timeline should contain {int} items")
    public void timelineItemCount(int expected) {
        assertThat(expPage().getTimelineItems().size()).isEqualTo(expected);
    }

    @Then("a timeline entry with role {string} should exist")
    public void timelineEntryWithRole(String role) {
        assertThat(expPage().hasItemWithRole(role))
                .as("Expected timeline entry: " + role)
                .isTrue();
    }

    @Then("that timeline entry company should contain {string}")
    public void timelineEntryCompany(String company) {
        assertThat(expPage().anyItemContains(company))
                .as("Expected company mention: " + company)
                .isTrue();
    }

    @Then("the first timeline entry should have a {string} status badge")
    public void firstItemBadge(String badge) {
        assertThat(expPage().firstItemHasStatusBadge(badge)).isTrue();
    }

    @Then("the first timeline entry date should contain {string}")
    public void firstItemDate(String date) {
        assertThat(expPage().getFirstItemDateText()).contains(date);
    }

    @Then("each timeline entry should have at least {int} bullet point")
    public void eachItemHasBullets(int min) {
        assertThat(expPage().eachItemHasBullets()).isTrue();
    }

    @Then("the first timeline entry bullets should mention {string}")
    public void firstItemBulletsMention(String keyword) {
        assertThat(expPage().firstItemBulletsContain(keyword))
                .as("First timeline entry bullets should mention: " + keyword)
                .isTrue();
    }
}
