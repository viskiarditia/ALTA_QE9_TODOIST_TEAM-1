@Task
Feature: Todois Task Feature

  @Task
  Scenario Outline: Get An Active task
    Given Get an active task with valid <id>
    When Send Get an active task request
    Then Status code should be 200 OK
    And Response body should be "Buy Coffee"
    And Validate Get an active task json schema
    Examples:
      | id         |
      | 6614134187 |

  @Task
  Scenario Outline: Get An Active task with invalid id
    Given Get an active task with invalid <id>
    When Send Get an active task request
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 999999 |
