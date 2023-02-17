Feature: Update Comments


  @Comments
  @PositiveCase
  Scenario Outline: Update comment valid with id
    Given Update comment with valid id <id>
    When Send post update comment request
    Then Status code is 200 OK
    Examples:
      | id         |
      | 3224747581 |