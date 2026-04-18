@regression @skills
Feature: Skills Section
  As a recruiter I want to see the candidate's technical skills
  so I can assess their competency level.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "skills" section

  @smoke
  Scenario: Skills section is visible
    Then the skills section should be visible

  Scenario: Skills section label is present
    Then the skills section should have a visible section label

  @smoke
  Scenario: Four skill category cards are displayed
    Then the skills section should contain 4 skill categories

  Scenario: Languages and Scripting category is present
    Then a skill category containing "Languages" should exist

  Scenario: Test Automation category is present
    Then a skill category containing "Test Automation" should exist

  Scenario: CI/CD category is present
    Then a skill category containing "CI/CD" should exist

  Scenario: Cloud and Tools category is present
    Then a skill category containing "Cloud" should exist

  Scenario: Python skill bar is displayed
    Then a skill bar for "Python" should be present

  Scenario: Java skill bar is displayed
    Then a skill bar for "Java" should be present

  Scenario: Jenkins skill bar is displayed
    Then a skill bar for "Jenkins" should be present

  Scenario: Docker skill bar is displayed
    Then a skill bar for "Docker" should be present

  Scenario: Selenium skill tag is displayed
    Then a skill tag "Selenium" should be present

  Scenario: Cucumber skill tag is displayed
    Then a skill tag "Cucumber" should be present

  Scenario: Robot Framework skill tag is displayed
    Then a skill tag "Robot Framework" should be present

  Scenario: TestNG skill tag is displayed
    Then a skill tag "TestNG" should be present

  Scenario: AWS skill tag is displayed
    Then a skill tag "AWS" should be present

  Scenario: Kubernetes skill tag is displayed
    Then a skill tag "Kubernetes" should be present
