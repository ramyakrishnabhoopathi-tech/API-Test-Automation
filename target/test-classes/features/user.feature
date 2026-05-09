Feature: Reqres API Automation

  Scenario: Validate Reqres User API

    Given I use the REST API
    When User retrieves user data
    Then Print response status code
    And Print first name from response
    And Print avatar URL from response
    And Update the email address
    And Delete the last name
