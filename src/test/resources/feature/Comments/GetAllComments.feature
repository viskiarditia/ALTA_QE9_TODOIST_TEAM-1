Feature: Get All Comments

  @Comments
  @PositiveCase
  Scenario: Get all comments with valid ID
    Given Get all comment with valid ID
    When Send all comments request
    Then Status code should be 200 OK
    And Validate get all comments json schema validator
