Feature: Get a Projects Todoist
  @Projects @Positive
  Scenario: Get a project with valid parameter id
    Given Get a project with valid id 2307902145
    When Send a get project request
    Then Status code should be 200 OK
    And Validate get a project with json schema validator

  @Projects @Negative
  Scenario Outline: Get a project with invalid id
    Given Get a project with invalid id "<id>"
    When Send a get project request
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 230225@a$# |
