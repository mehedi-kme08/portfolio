@regression @publications
Feature: Publications Section
  As a visitor I want to see research publications
  so I can evaluate the candidate's academic contributions.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "publications" section

  @smoke
  Scenario: Publications section is visible
    Then the publications section should be visible

  Scenario: Publications section title contains "Research"
    Then the publications section title should contain "Research"

  @smoke
  Scenario: Two publication cards are displayed
    Then the publications section should contain 2 publication cards

  Scenario: First publication is numbered 01
    Then the first publication card should have number "01"

  Scenario: First publication title mentions wind turbine
    Then the first publication card title should contain "Wind Turbine"

  Scenario: First publication is from 2017
    Then the first publication card date should contain "2017"

  Scenario: Second publication is numbered 02
    Then the second publication card should have number "02"

  Scenario: Second publication title mentions wind turbine blade
    Then the second publication card title should contain "Wind Turbine Blade"

  Scenario: Second publication is from 2017
    Then the second publication card date should contain "2017"

  Scenario: First publication journal is displayed
    Then the first publication card should show a journal name
