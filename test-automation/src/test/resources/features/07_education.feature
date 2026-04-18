@regression @education
Feature: Education Section
  As a recruiter I want to verify academic qualifications
  so I can confirm educational requirements are met.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "education" section

  @smoke
  Scenario: Education section is visible
    Then the education section should be visible

  Scenario: Education section title contains "Education"
    Then the education section title should contain "Education"

  @smoke
  Scenario: Masters degree card is present
    Then an education card for "Master of Science" should exist

  Scenario: Masters degree in Electrical Engineering
    Then the Masters degree card should mention "Electrical Engineering"

  Scenario: Masters degree from Georgia Southern
    Then the Masters degree card should mention "Georgia Southern"

  @smoke
  Scenario: Bachelors degree card is present
    Then an education card for "Bachelor of Science" should exist

  Scenario: Bachelors degree in Mechanical Engineering
    Then the Bachelors degree card should mention "Mechanical Engineering"

  Scenario: Bachelors degree from KUET
    Then the Bachelors degree card should mention "KUET"

  Scenario: DFSS Green Belt credential is present
    Then a credential card containing "DFSS Green Belt" should exist

  @smoke
  Scenario: DFSS Black Belt credential is present
    Then a credential card containing "DFSS Black Belt" should exist

  Scenario: IEEE Member credential is present
    Then a credential card containing "IEEE Member" should exist

  Scenario: Global Ambassador credential is present
    Then a credential card containing "Global Ambassador" should exist
