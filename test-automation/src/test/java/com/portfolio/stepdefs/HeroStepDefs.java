package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.HeroPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class HeroStepDefs {

    private HeroPage heroPage() {
        return new HeroPage(DriverManager.getDriver());
    }

    @Then("the hero section should be visible")
    public void heroVisible() {
        assertThat(heroPage().isHeroVisible()).isTrue();
    }

    @Then("the hero badge should be visible")
    public void heroBadgeVisible() {
        assertThat(heroPage().isBadgeVisible()).isTrue();
    }

    @Then("the hero badge text should contain {string}")
    public void heroBadgeText(String expected) {
        assertThat(heroPage().getBadgeText()).contains(expected);
    }

    @Then("the hero name should contain {string}")
    public void heroNameContains(String expected) {
        assertThat(heroPage().getHeroNameText()).contains(expected);
    }

    @Then("the typing text element should be present in the hero section")
    public void typingTextPresent() {
        assertThat(heroPage().isTypedTextPresent()).isTrue();
    }

    @Then("the {string} hero button should be present")
    public void heroButtonPresent(String buttonText) {
        assertThat(heroPage().hasButtonWithText(buttonText)).isTrue();
    }

    @Then("the {string} hero button href should be {string}")
    public void heroButtonHref(String buttonText, String expectedHref) {
        String href = heroPage().getButtonHref(buttonText);
        assertThat(href).contains(expectedHref);
    }

    @Then("the {string} hero button href should contain {string}")
    public void heroButtonHrefContains(String buttonText, String partial) {
        assertThat(heroPage().getButtonHref(buttonText)).contains(partial);
    }

    @Then("the LinkedIn hero button should have target {string}")
    public void linkedInButtonTarget(String expected) {
        assertThat(heroPage().getButtonTarget("LinkedIn")).isEqualTo(expected);
    }

    @Then("the hero stats container should be visible")
    public void heroStatsVisible() {
        assertThat(heroPage().isStatsVisible()).isTrue();
    }

    @Then("a hero stat containing {string} should be visible")
    public void heroStatContaining(String text) {
        assertThat(heroPage().hasStatContaining(text))
                .as("Expected hero stat containing: " + text)
                .isTrue();
    }

    @Then("the hero section height should be at least the viewport height")
    public void heroHeightAtLeastViewport() {
        HeroPage page = heroPage();
        assertThat(page.getHeroSectionHeight()).isGreaterThanOrEqualTo(page.getViewportHeight() - 10);
    }
}
