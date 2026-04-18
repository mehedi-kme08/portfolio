package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.NavigationPage;
import io.cucumber.java.en.*;
import io.cucumber.java.DataTableType;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationStepDefs {

    private NavigationPage navPage() {
        return new NavigationPage(DriverManager.getDriver());
    }

    @Given("I am on the portfolio website")
    public void iAmOnThePortfolioWebsite() {
        // Navigation already performed in Hooks @Before; just verify load
        assertThat(DriverManager.getDriver().getTitle()).isNotBlank();
    }

    @Then("the page title should contain {string}")
    public void pageTitleContains(String expected) {
        assertThat(DriverManager.getDriver().getTitle()).contains(expected);
    }

    @Then("the navigation bar should be visible")
    public void navBarIsVisible() {
        assertThat(navPage().isNavVisible()).isTrue();
    }

    @Then("the nav logo text should be {string}")
    public void navLogoText(String expected) {
        assertThat(navPage().getLogoText()).isEqualTo(expected);
    }

    @Then("the navigation should contain the following links:")
    public void navContainsLinks(DataTable table) {
        List<String> expected = table.asList();
        NavigationPage nav = navPage();
        for (String linkText : expected) {
            assertThat(nav.hasNavLinkWithText(linkText))
                    .as("Expected nav link: " + linkText)
                    .isTrue();
        }
    }

    @Then("the navigation bar should have a {string} CTA button")
    public void navHasCTA(String text) {
        assertThat(navPage().hasCTAButton()).isTrue();
    }

    @When("I click the navigation link {string}")
    public void clickNavLink(String text) {
        navPage().clickNavLinkByText(text);
    }

    @When("I click the navigation CTA button")
    public void clickNavCTA() {
        navPage().clickCTA();
    }

    @When("I click the navigation logo")
    public void clickNavLogo() {
        navPage().clickLogo();
    }

    @When("I scroll down to the {string} section")
    public void scrollToSection(String sectionId) {
        new com.portfolio.pages.NavigationPage(DriverManager.getDriver()).scrollToSection(sectionId);
    }

    @When("I scroll to the bottom of the page")
    public void scrollToBottom() {
        new com.portfolio.pages.NavigationPage(DriverManager.getDriver()).scrollToBottom();
    }

    // ── Section-in-viewport assertions ────────────────────────────────────────

    @Then("the hero section should be in the viewport")
    public void heroInViewport() {
        assertSectionInViewport("hero");
    }

    @Then("the about section should be in the viewport")
    public void aboutInViewport() {
        assertSectionInViewport("about");
    }

    @Then("the skills section should be in the viewport")
    public void skillsInViewport() {
        assertSectionInViewport("skills");
    }

    @Then("the experience section should be in the viewport")
    public void experienceInViewport() {
        assertSectionInViewport("experience");
    }

    @Then("the achievements section should be in the viewport")
    public void achievementsInViewport() {
        assertSectionInViewport("achievements");
    }

    @Then("the education section should be in the viewport")
    public void educationInViewport() {
        assertSectionInViewport("education");
    }

    @Then("the publications section should be in the viewport")
    public void publicationsInViewport() {
        assertSectionInViewport("publications");
    }

    @Then("the contact section should be in the viewport")
    public void contactInViewport() {
        assertSectionInViewport("contact");
    }

    private void assertSectionInViewport(String sectionId) {
        WebDriver driver = DriverManager.getDriver();
        Boolean topVisible = (Boolean) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "var el = document.getElementById(arguments[0]);" +
            "if (!el) return false;" +
            "var rect = el.getBoundingClientRect();" +
            "return rect.top <= window.innerHeight && rect.bottom >= 0;",
            sectionId);
        assertThat(topVisible).as("Section #" + sectionId + " should be in the viewport").isTrue();
    }
}
