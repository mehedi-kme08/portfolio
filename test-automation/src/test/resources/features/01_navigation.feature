@regression @navigation
Feature: Navigation Bar
  As a visitor I want to navigate between sections
  so I can quickly find the information I need.

  Background:
    Given I am on the portfolio website

  @smoke
  Scenario: Page title is correct
    Then the page title should contain "Md Mehedi Hasan"

  @smoke
  Scenario: Navigation bar is visible on page load
    Then the navigation bar should be visible

  Scenario: Navigation logo text is displayed
    Then the nav logo text should be "MH."

  Scenario: All navigation links are present
    Then the navigation should contain the following links:
      | About        |
      | Skills       |
      | Experience   |
      | Achievements |
      | Education    |
      | Research     |
      | Contact      |

  Scenario: Navigation CTA button is present
    Then the navigation bar should have a "Contact" CTA button

  Scenario: Clicking About link scrolls to About section
    When I click the navigation link "About"
    Then the about section should be in the viewport

  Scenario: Clicking Skills link scrolls to Skills section
    When I click the navigation link "Skills"
    Then the skills section should be in the viewport

  Scenario: Clicking Experience link scrolls to Experience section
    When I click the navigation link "Experience"
    Then the experience section should be in the viewport

  Scenario: Clicking Achievements link scrolls to Achievements section
    When I click the navigation link "Achievements"
    Then the achievements section should be in the viewport

  Scenario: Clicking Education link scrolls to Education section
    When I click the navigation link "Education"
    Then the education section should be in the viewport

  Scenario: Clicking Research link scrolls to Publications section
    When I click the navigation link "Research"
    Then the publications section should be in the viewport

  Scenario: Clicking Contact CTA scrolls to Contact section
    When I click the navigation CTA button
    Then the contact section should be in the viewport

  Scenario: Nav logo click scrolls back to top
    When I scroll down to the "about" section
    And I click the navigation logo
    Then the hero section should be in the viewport
