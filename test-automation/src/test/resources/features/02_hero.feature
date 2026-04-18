@regression @hero
Feature: Hero Section
  As a recruiter I want to see key profile information immediately
  so I can quickly assess the candidate.

  Background:
    Given I am on the portfolio website

  @smoke
  Scenario: Hero section is displayed
    Then the hero section should be visible

  Scenario: Availability badge is present
    Then the hero badge should be visible
    And the hero badge text should contain "Available for Senior"

  @smoke
  Scenario: Candidate full name is displayed
    Then the hero name should contain "Md Mehedi"
    And the hero name should contain "Hasan"

  Scenario: Typing animation element is present
    Then the typing text element should be present in the hero section

  @smoke
  Scenario: Get In Touch button links to contact section
    Then the "Get In Touch" hero button should be present
    And the "Get In Touch" hero button href should be "#contact"

  Scenario: LinkedIn button is present with correct URL
    Then the "LinkedIn Profile" hero button should be present
    And the "LinkedIn Profile" hero button href should contain "linkedin.com/in/mehedihasan91"

  Scenario: LinkedIn button opens in new tab
    Then the LinkedIn hero button should have target "_blank"

  Scenario: Hero statistics section is displayed
    Then the hero stats container should be visible

  Scenario: Years of experience stat is shown
    Then a hero stat containing "Years Experience" should be visible

  Scenario: Teams supported stat is shown
    Then a hero stat containing "Teams Supported" should be visible

  Scenario: Connections stat is shown
    Then a hero stat containing "Connections" should be visible

  Scenario: Publications stat is shown
    Then a hero stat containing "Publications" should be visible

  Scenario: Hero section occupies full viewport height
    Then the hero section height should be at least the viewport height
