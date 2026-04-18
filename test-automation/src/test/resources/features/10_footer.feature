@regression @footer
Feature: Footer
  As a visitor I want useful links in the footer
  so I can navigate even from the bottom of the page.

  Background:
    Given I am on the portfolio website
    And I scroll to the bottom of the page

  @smoke
  Scenario: Footer copyright text is present
    Then the footer should display copyright text containing "Md Mehedi Hasan"

  Scenario: Footer copyright includes current or recent year
    Then the footer copyright text should contain "2026"

  Scenario: Footer has email link
    Then the footer should have a link to "mailto:mhasan.kme@gmail.com"

  Scenario: Footer has LinkedIn link
    Then the footer should have a link containing "linkedin.com/in/mehedihasan91"

  Scenario: Footer has publications link
    Then the footer should have an anchor link to "#publications"

  Scenario: Footer LinkedIn link opens in new tab
    Then the footer LinkedIn link should open in a new tab
