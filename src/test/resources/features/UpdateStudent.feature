@studentAPI @updateStudent
Feature: To update a student

  @updateStudent
  Scenario Outline: To update a student with ID
    Given user has access to endpoint "/updateStudent"
    And user updates a student
      | firstname   | lastname   | id   | nationality   | studentClass   |
      | <firstname> | <lastname> | <id> | <nationality> | <studentClass> |
    Then user should get the response code 200

    Examples:
      | firstname | lastname | id | nationality | studentClass |
      |    John   |   Martin | 3  |   Canada    |      1A      |
