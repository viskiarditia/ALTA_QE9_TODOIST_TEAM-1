Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Get all section with valid project id
    Given Get all section with valid project <id>
    When Send get all section request
    Then Status code should be 200 OK
    And Validate get all section json schema
    Examples:
      | id         |
      | 2307902145 |

  @Section
  Scenario Outline: Get all section with invalid project id
    Given Get all section with valid project "<id>"
    When Send get all section invalid project id request
    Then Status code should be 400 Bad Request
    And Validate get all section json schema
    Examples:
      | id       |
      | asekasek |

