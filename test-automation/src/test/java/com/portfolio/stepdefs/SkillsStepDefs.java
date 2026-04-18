package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.SkillsPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SkillsStepDefs {

    private SkillsPage skillsPage() {
        return new SkillsPage(DriverManager.getDriver());
    }

    @Then("the skills section should be visible")
    public void skillsVisible() {
        assertThat(skillsPage().isSkillsVisible()).isTrue();
    }

    @Then("the skills section should have a visible section label")
    public void skillsSectionLabel() {
        assertThat(skillsPage().isSectionLabelVisible()).isTrue();
    }

    @Then("the skills section should contain {int} skill categories")
    public void skillCategoryCount(int expected) {
        assertThat(skillsPage().getCategories().size()).isEqualTo(expected);
    }

    @Then("a skill category containing {string} should exist")
    public void skillCategoryContaining(String text) {
        assertThat(skillsPage().hasCategoryContaining(text))
                .as("Expected skill category containing: " + text)
                .isTrue();
    }

    @Then("a skill bar for {string} should be present")
    public void skillBarFor(String name) {
        assertThat(skillsPage().hasSkillBarFor(name))
                .as("Expected skill bar for: " + name)
                .isTrue();
    }

    @Then("a skill tag {string} should be present")
    public void skillTagPresent(String tagName) {
        assertThat(skillsPage().hasSkillTag(tagName))
                .as("Expected skill tag: " + tagName)
                .isTrue();
    }
}
