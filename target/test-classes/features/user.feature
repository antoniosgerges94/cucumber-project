Feature: User Feature
  Scenario: Login Functionality
    Given User is at the login page
    When User fill the email and password fields then login
    Then Welcome message should be displayed