Feature: Create New Comment

  @Comments
  @PositiveCase
  Scenario: Create new comment with valid task_id and validate JSON Schema
    Given Create new comment with valid task_id
    When create comment request with valid task ID
    Then Status code should be 200 OK
    And Response body should contain name Comment "Need one bottle of milk"
    And Validate create comment json schema validator

  @Negativecase
  Scenario: Create new comment with invalid "task_id"
    Given Create new comment with invalid task_id
    When Create comment request with invalid task id
    And Respone status code 403 Forbidden
