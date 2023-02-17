Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Delete section with id
    Given Delete section with valid id <id>
    When Send delete section with valid request
    Then Status code should with valid be 204 No Content
    Examples:
      | id        |
      | 115885102 |

  @Section
  Scenario Outline: Delete section with invalid id
    Given Delete section with invalid id "<id>"
    When Send delete section with invalid request
    Then Status Code should be 400 Bad Request
    Examples:
      | id      |
      | 123asek |