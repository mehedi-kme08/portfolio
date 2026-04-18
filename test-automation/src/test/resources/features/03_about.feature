@regression @about
Feature: About Section
  As a recruiter I want to read a professional summary
  so I can understand the candidate's background.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "about" section

  @smoke
  Scenario: About section is visible
    Then the about section should be visible

  Scenario: About section label reads "About Me"
    Then the about section label should be "About Me"

  Scenario: About section title mentions quality
    Then the about section title should contain "quality"

  Scenario: About section contains descriptive text
    Then the about section should have at least 2 text paragraphs

  Scenario: About text mentions General Motors
    Then the about text should mention "General Motors"

  Scenario: About text mentions years of experience
    Then the about text should mention "5+"

  @smoke
  Scenario: All four highlight cards are displayed
    Then the about section should display 4 highlight cards

  Scenario: Framework Ownership card is present
    Then an about highlight card with title "Framework Ownership" should exist

  Scenario: CI/CD Engineering card is present
    Then an about highlight card with title "CI/CD Engineering" should exist

  Scenario: Infrastructure card is present
    Then an about highlight card with title "Infrastructure as Code" should exist

  Scenario: Research card is present
    Then an about highlight card with title "Research & Publications" should exist
