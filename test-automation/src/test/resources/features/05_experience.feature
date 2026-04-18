@regression @experience
Feature: Experience Section
  As a recruiter I want to review the candidate's work history
  so I can evaluate their professional progression.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "experience" section

  @smoke
  Scenario: Experience section is visible
    Then the experience section should be visible

  Scenario: Experience section title contains "Experience"
    Then the experience section title should contain "Experience"

  @smoke
  Scenario: Four timeline entries are displayed
    Then the experience timeline should contain 4 items

  @smoke
  Scenario: Current role at General Motors is displayed
    Then a timeline entry with role "Test Automation Framework Engineer" should exist
    And that timeline entry company should contain "General Motors"

  Scenario: Current role has CURRENT badge
    Then the first timeline entry should have a "CURRENT" status badge

  Scenario: Second General Motors role is displayed
    Then a timeline entry with role "Test Automation Engineer" should exist

  Scenario: Stellantis role is displayed
    Then a timeline entry with role "Software Modeling Engineer" should exist
    And that timeline entry company should contain "Stellantis"

  Scenario: Graduate Research role is displayed
    Then a timeline entry with role "Graduate Research Assistant" should exist
    And that timeline entry company should contain "Georgia Southern"

  Scenario: Current role date range starts with Apr 2024
    Then the first timeline entry date should contain "Apr 2024"

  Scenario: Each timeline entry has bullet points
    Then each timeline entry should have at least 1 bullet point

  Scenario: Current role mentions Python
    Then the first timeline entry bullets should mention "Python"
