Feature: Login Feature
  As a user
  I want to be able to log in to my account
  So that I can access my account features

  Scenario: Send OTP Validation
    Given I am on the login page
    When I send OTP for game "bgmi"
    Then OTP should be sent successfully

  Scenario: Verify OTP Validation
    Given I am on the OTP verification page
    When I verify OTP "5555" for game "bgmi"
    Then OTP should be verified successfully

  Scenario: Select Game Validation
    Given I am on the game selection page
    When I select game "bgmi"
    Then Game should be selected successfully
