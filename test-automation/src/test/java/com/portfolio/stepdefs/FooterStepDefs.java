package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.FooterPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterStepDefs {

    private FooterPage footerPage() {
        return new FooterPage(DriverManager.getDriver());
    }

    @Then("the footer should display copyright text containing {string}")
    public void footerCopyrightContains(String expected) {
        assertThat(footerPage().getFooterText()).contains(expected);
    }

    @Then("the footer copyright text should contain {string}")
    public void footerTextContains(String text) {
        assertThat(footerPage().getFooterText()).contains(text);
    }

    @Then("the footer should have a link to {string}")
    public void footerHasLinkTo(String href) {
        assertThat(footerPage().hasLinkWithHref(href))
                .as("Expected footer link: " + href)
                .isTrue();
    }

    @Then("the footer should have a link containing {string}")
    public void footerHasLinkContaining(String partial) {
        assertThat(footerPage().hasLinkWithHref(partial))
                .as("Expected footer link containing: " + partial)
                .isTrue();
    }

    @Then("the footer should have an anchor link to {string}")
    public void footerHasAnchorLink(String anchor) {
        assertThat(footerPage().hasLinkWithHref(anchor))
                .as("Expected footer anchor: " + anchor)
                .isTrue();
    }

    @Then("the footer LinkedIn link should open in a new tab")
    public void footerLinkedInNewTab() {
        assertThat(footerPage().linkedInOpensInNewTab()).isTrue();
    }
}
