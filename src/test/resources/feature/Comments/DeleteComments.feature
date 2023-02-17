Feature: Delete Comments


  @Comments
  Scenario Outline: Delete comments with valid id
    Given Task delete comments with id <id>
    When Send task delete comments request
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 3224747581 |
