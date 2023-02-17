Feature: Get All Projects Todoist
  @Projects @Positive
  Scenario: Get all projects valid parameter
    Given Get all projects valid parameter
    When Send all projects request
    Then Status code should be 200 OK
    And Validate get all projects json schema validator

  @Projects @Negative
  Scenario: Get all projects with invalid token
    Given Get all projects with invalid token
    When Send invalid token to get all projects
    Then Status code should be 401 Unauthorize

  @Projects @Negative
  Scenario: Get all projects with invalid url path
    Given Get all projects with invalid path url
    When Send invalid path url to get all projects request
    Then Status code should be 404 Not Found

