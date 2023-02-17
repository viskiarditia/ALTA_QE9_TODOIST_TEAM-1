Feature: Delete Projects Todoist
  @Projects @Positive
  Scenario Outline: Delete project with valid parameter id
    Given Delete a project with valid id <id>
    When Send request to delete a project
    Then Status code should be 204 No Content
    Examples:
      | id         |
      | 2302037359 |

  @Projects @Negative
  Scenario Outline: Delete project with invalid parameter id
    Given Delete project with invalid id "<id>"
    When Send request to delete a project
    Then Status code should be 400 Bad Request
    Examples:
      | id         |
      | 2302037abc |