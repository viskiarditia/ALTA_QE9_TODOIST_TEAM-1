Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Delete section with id
    Given Delete section with valid id <id>
    When Send delete section with valid request
    Then Status code is 204 No Content
    Examples:
      | id        |
      | 115885102 |

  @Section
  Scenario Outline: Delete section with invalid id
    Given Delete section with invalid id "<id>"
    When Send delete section with invalid request
    Then Status code should be 404 Not Found
    Examples:
      | id      |
      | 123asek |