@Task
Feature: Todois Task Feature

  @Task #Positive
  Scenario: Get active task
    Given Set get active task
    When Send request get active task
    Then Status code should be 200 OK
    And Validate get active task json schema



