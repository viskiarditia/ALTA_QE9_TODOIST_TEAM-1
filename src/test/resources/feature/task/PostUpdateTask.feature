@Task
Feature: Todois Task Feature

  @Task #Positive
  Scenario Outline: Update A Task
    Given Update task with valid json and <id>
    When Send update task request
    Then Status code should be 200 OK
    Examples:
      | id         |
      | 6614134187 |

  @Task #Negative
  Scenario Outline: Update A Task
    Given Update task with valid json and <id>
    When Send update task request
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 999999 |