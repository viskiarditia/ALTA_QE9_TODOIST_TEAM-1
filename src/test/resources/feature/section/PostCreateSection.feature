Feature: Todoist Section Feature test

  @Section
  Scenario Outline: Post new section with valid body
    Given Post new section with valid body
    When Send post new section request
    Then Status code should be 200 OK
    And Response body page should contain project_id <project> and name <name>
    And Validate create section json schema
    Examples:
      | project    | name            |
      | 2308074714 | "Viski Arditia" |

  @Section
  Scenario: Post new section with invalid Empty fill Field Name
    Given Post new section with invalid body Empty fill Field Name
    When Send post new section invalid request
    Then Status code should be 400 Bad Request

  @Section
  Scenario: Post new section with invalid without Field Name
    Given Post new section with invalid body without Field Name
    When Send post new section invalid request
    Then Status code should be 400 Bad Request

  @Section
  Scenario: Post new section with invalid Empty fill Field Project Id
    Given Post new section with invalid body Empty fill Field Project Id
    When Send post new section invalid request
    Then Status code should be 400 Bad Request

  @Section
  Scenario: Post new section with invalid without Field Project Id
    Given Post new section with invalid body without Field Project Id
    When Send post new section invalid request
    Then Status code should be 400 Bad Request
