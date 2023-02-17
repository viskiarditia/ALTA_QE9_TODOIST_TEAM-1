Feature: Create a New Projects Todoist
  @Projects @Positive
  Scenario: Post create a new project with valid name and listed color
    Given Post create a new project with valid name and listed color in json body
    When Send post create project request
    Then Status code should be 200 OK
    And Response body should contain name "ica Aisyah" and color "blue"
    And Validate create project json schema validator with valid name and listed color

  @Projects @Positive
  Scenario: Post create a new project with valid name and listed view_style
    Given Post create a new project with valid name and listed view_style in json body
    When Send post create project request
    Then Status code should be 200 OK
    And Response body should contain name "ica Aisyah" and view_style "board"
    And Validate create project json schema validator with valid name and listed view_style

  @Projects @Negative
  Scenario: Post create a new project without name
    Given Post create a new project without name in json body
    When Send post create project request
    Then Status code should be 400 Bad Request

