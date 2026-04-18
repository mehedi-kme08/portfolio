@regression @contact
Feature: Contact Section
  As a recruiter I want to contact the candidate through various channels
  so I can schedule interviews and discussions.

  Background:
    Given I am on the portfolio website
    And I scroll down to the "contact" section

  @smoke
  Scenario: Contact section is visible
    Then the contact section should be visible

  Scenario: Contact section title contains "Touch"
    Then the contact section title should contain "Touch"

  @smoke
  Scenario: Email contact link is present and correct
    Then a contact link with label "Email" should exist
    And the email contact link href should be "mailto:mhasan.kme@gmail.com"

  @smoke
  Scenario: Phone contact link is present and correct
    Then a contact link with label "Phone" should exist
    And the phone contact link href should be "tel:+12488619788"

  @smoke
  Scenario: LinkedIn contact link is present
    Then a contact link with label "LinkedIn" should exist
    And the LinkedIn contact link href should contain "linkedin.com/in/mehedihasan91"

  Scenario: LinkedIn contact link opens in new tab
    Then the LinkedIn contact link should have target "_blank"

  Scenario: Location contact link is present
    Then a contact link with label "Location" should exist

  @smoke
  Scenario: Contact form is displayed
    Then the contact form should be visible

  Scenario: First name field is present
    Then the contact form should have an input field with id "fname"

  Scenario: Last name field is present
    Then the contact form should have an input field with id "lname"

  Scenario: Email field is present
    Then the contact form should have an input field with id "email"

  Scenario: Subject field is present
    Then the contact form should have an input field with id "subject"

  Scenario: Message textarea is present
    Then the contact form should have a textarea with id "message"

  Scenario: Send Message button is present
    Then the contact form submit button should have text "Send Message"

  Scenario: First name field has placeholder Jane
    Then the "fname" field placeholder should be "Jane"

  Scenario: Email field has correct placeholder
    Then the "email" field placeholder should contain "company.com"

  Scenario: First name field is required
    Then the "fname" input should be marked as required

  Scenario: Last name field is required
    Then the "lname" input should be marked as required

  Scenario: Email field is required
    Then the "email" input should be marked as required

  Scenario: Message field is required
    Then the "message" textarea should be marked as required

  Scenario: Subject field is not required
    Then the "subject" input should not be marked as required

  Scenario: Form can be filled with valid data
    When I fill in the contact form with:
      | fname   | John                          |
      | lname   | Doe                           |
      | email   | john.doe@example.com          |
      | subject | Test Opportunity              |
      | message | Hello, I would like to connect regarding a test automation role. |
    Then all contact form fields should be filled

  Scenario: Email field rejects invalid email format
    When I enter "not-an-email" in the "email" field
    And I click the contact form submit button
    Then the browser should flag the email field as invalid

  Scenario: Submit button is disabled after click
    When I fill in the contact form with:
      | fname   | Jane                          |
      | lname   | Smith                         |
      | email   | jane.smith@example.com        |
      | subject | Collaboration                 |
      | message | Interested in collaborating on a test automation project. |
    And I click the contact form submit button
    Then the submit button text should change from "Send Message"
