@regression @achievements
Feature: Achievements Section
  As a recruiter I want to see key measurable achievements
  so I can understand the candidate's impact.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "achievements" section

  @smoke
  Scenario: Achievements section is visible
    Then the achievements section should be visible

  Scenario: Achievements section title contains "Achievements"
    Then the achievements section title should contain "Achievements"

  @smoke
  Scenario: Achievement cards are displayed
    Then the achievements section should contain at least 5 achievement cards

  Scenario: Engineering teams achievement card is present
    Then an achievement card containing "Engineering Teams" should exist

  Scenario: Research publications achievement card is present
    Then an achievement card containing "Research Publications" should exist

  Scenario: Manual setup achievement card is present
    Then an achievement card containing "Manual Env Setup" should exist

  Scenario: Framework owner achievement card is present
    Then an achievement card containing "Framework Owner" should exist

  Scenario: Release velocity achievement card is present
    Then an achievement card containing "Release Velocity" should exist
