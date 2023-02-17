Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Post update section with valid json
    Given Post update section with valid json with <id>
    When Send post update section request
    Then Status code update should create be 204 No Content
    Examples:
      | id        |
      | 115885144 |

  @Section
  Scenario Outline: Post update section with invalid json
    Given Post update section with invalid id "<id>"
    When Send post update section invalid request
    Then Status Code should be 400 Bad Request
    Examples:
      | id      |
      | 123asek |