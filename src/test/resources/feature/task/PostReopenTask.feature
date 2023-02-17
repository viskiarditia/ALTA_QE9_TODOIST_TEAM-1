@Task
Feature: Todois Task Feature

  @Task #Positive
  Scenario Outline: Reopen A Task
    Given Reopen a task with <id>
    When Send Reopen A Task
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 6614134187 |

  @Task #Negative
  Scenario Outline: Reopen A Task
    Given Reopen a task with <id>
    When Send Reopen A Task
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 999999 |
