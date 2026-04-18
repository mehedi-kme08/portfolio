package com.portfolio.stepdefs;

import com.portfolio.config.DriverManager;
import com.portfolio.pages.PublicationsPage;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicationsStepDefs {

    private PublicationsPage pubPage() {
        return new PublicationsPage(DriverManager.getDriver());
    }

    @Then("the publications section should be visible")
    public void publicationsVisible() {
        assertThat(pubPage().isPublicationsVisible()).isTrue();
    }

    @Then("the publications section title should contain {string}")
    public void pubSectionTitle(String expected) {
        assertThat(pubPage().getSectionTitle()).containsIgnoringCase(expected);
    }

    @Then("the publications section should contain {int} publication cards")
    public void pubCardCount(int expected) {
        assertThat(pubPage().getPublicationCards().size()).isEqualTo(expected);
    }

    @Then("the first publication card should have number {string}")
    public void firstPubNumber(String number) {
        assertThat(pubPage().getCardText(0)).contains(number);
    }

    @Then("the first publication card title should contain {string}")
    public void firstPubTitle(String text) {
        assertThat(pubPage().getCardText(0)).containsIgnoringCase(text);
    }

    @Then("the first publication card date should contain {string}")
    public void firstPubDate(String date) {
        assertThat(pubPage().getCardText(0)).contains(date);
    }

    @Then("the second publication card should have number {string}")
    public void secondPubNumber(String number) {
        assertThat(pubPage().getCardText(1)).contains(number);
    }

    @Then("the second publication card title should contain {string}")
    public void secondPubTitle(String text) {
        assertThat(pubPage().getCardText(1)).containsIgnoringCase(text);
    }

    @Then("the second publication card date should contain {string}")
    public void secondPubDate(String date) {
        assertThat(pubPage().getCardText(1)).contains(date);
    }

    @Then("the first publication card should show a journal name")
    public void firstPubJournal() {
        assertThat(pubPage().cardHasJournal(0)).isTrue();
    }
}
