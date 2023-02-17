Feature: Update a Projects Todoist
  @Projects @Positive
  Scenario: Post update project with valid parameter id
    Given Post update project with valid json body and valid id 2308080569
    When Send post update project request
    Then Status code should be 200 OK
    And Response body should contain name "ica Aisyah aja" and color "red"
    And Validate update project json schema validator with valid name and listed color

  @Projects @Negative
  Scenario Outline: Post update project with invalid id
    Given Post update project with invalid id "<id>"
    When Send post update project request
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 230225wfw@ |