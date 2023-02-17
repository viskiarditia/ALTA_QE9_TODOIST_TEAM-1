@Task
Feature: Todois Task Feature

 @Task #Positive
Scenario: Create A New Task
  Given Post create user with file json
  When Send Create Active Task
  Then Status code should be 200 OK
  And Response body Should contain name "Making Salad" and date "tomorrow at 14:00" and priority 3
  And Validate Create a new task json schema

  @Task #Negative
  Scenario: Create A New Task
    Given Post create user with blank file json
    When Send Create Active Task
    Then Status code should be 400 Bad Request
    And Response body Should be error "Invalid argument value"