Feature: Get singgle Comment

  @Comments
  @PositiveCase
  Scenario Outline: Get comment with valid id
    Given Get comment with valid id <id>
    When Send get comment request
    Then Status code is 200 OK
    And Validate get comment json schema validator
    Examples:
      | id         |
      | 3224747581 |



  @PositiveCase
  Scenario Outline: Get comment with invalid id
    Given Get comment with valid id <id>
    When Send get comment request
    Then Status code is 404 Not Found
    Examples:
      | id         |
      | 12345678910 |

