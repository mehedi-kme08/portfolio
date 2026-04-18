package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.AchievementsPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AchievementsStepDefs {

    private AchievementsPage achPage() {
        return new AchievementsPage(DriverManager.getDriver());
    }

    @Then("the achievements section should be visible")
    public void achievementsVisible() {
        assertThat(achPage().isAchievementsVisible()).isTrue();
    }

    @Then("the achievements section title should contain {string}")
    public void achievementsSectionTitle(String expected) {
        assertThat(achPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("the achievements section should contain at least {int} achievement cards")
    public void achievementCardCount(int min) {
        assertThat(achPage().getAchievementCards().size()).isGreaterThanOrEqualTo(min);
    }

    @Then("an achievement card containing {string} should exist")
    public void achievementCardContaining(String text) {
        assertThat(achPage().hasCardContaining(text))
                .as("Expected achievement card containing: " + text)
                .isTrue();
    }
}
