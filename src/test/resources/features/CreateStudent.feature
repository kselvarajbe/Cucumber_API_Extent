@studentAPI @createStudent
Feature: To create a new student

  @createStudentDataTable
  Scenario Outline: To create new student using cucumber Data Table
    Given user has access to endpoint "/addStudent"
    When user creates a student
      | firstname   | lastname   | id   | nationality   | studentClass   |
      | <firstname> | <lastname> | <id> | <nationality> | <studentClass> |
    Then user should get the response code 200

    Examples: 
      | firstname | lastname | id | nationality | studentClass |
      | Selvaraj  | Karuppiah| 1  | Indian      |      1A      |
      | Selva     | Raj      | 2  | Sinagpore   |      3A      |


  @createStudentFromJSON
  Scenario Outline: To create new student using JSON data
    Given user has access to endpoint "/addStudent"
    When user creates a student using data "<dataKey>" from JSON file "<JSONFile>"
    Then user should get the response code 200

    Examples: 
      | dataKey | JSONFile         |
      | create3 | studentBody.json |
      | create4 | studentBody.json |
