Feature: Collaborator Projects Todoist
  @Projects @Positive
  Scenario Outline: Get All Collaborators with Valid ID
    Given Get all collaborators with valid id <id>
    When Send collaborator project request
    Then Status code should be 200 OK
    And Validate collaborator all project json schema validator
    Examples:
      | id         |
      | 2307902145 |
