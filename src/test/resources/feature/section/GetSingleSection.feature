Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Get single section with valid id
    Given Get single section with valid <id>
    When Send get single section request
    Then Status code should be 200 OK
    And Validate get single section json schema
    Examples:
      | id        |
      | 115885144 |

  @Section
  Scenario Outline: Get single section with invalid id
    Given Get single section with invalid id "<id>"
    When Send get single section invalid id request
    Then Status code should be 404 Not Found
    And Validate get single section json schema
    Examples:
      | id      |
      | 123asek |