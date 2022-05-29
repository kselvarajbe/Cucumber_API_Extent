@studentAPI @deleteStudent
Feature: To delete a student

  @deleteStudentIDs
  Scenario Outline: To delete a student with ID
    Given user has access to endpoint "/deleteStudent"
    When user deletes a student
      | id   |
      | <id> |
    Then user should get the response code 200

    Examples:
      | id |
      #| 1  |
      #| 2  |
      #| 3  |
      | 4  |


