@Task
Feature: Todois Task Feature

  @Task #Positive
  Scenario Outline: Close a task
    Given Close a task with valid <id>
    When Send close a task request
    Then Status code should be 204 NoContent
    Examples:
      | id         |
      | 6614134187 |

  @Task #Negative
  Scenario Outline: Close a task
    Given Close a task with valid <id>
    When Send close a task request
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 999999 |