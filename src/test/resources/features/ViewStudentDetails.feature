@studentAPI @viewStudent
Feature: To view the Student details

  @viewStudentDetails
  Scenario: To view student details with ID and Class
    Given user has access to endpoint "/fetchStudents?id=2&studentClass=3A"
    When user makes a request to view student IDs
    When user makes a request to view details of a student ID
    Then user should get the response code 200

  @viewStudentDetails
  Scenario: To view student details with class
    Given user has access to endpoint "/fetchStudents?studentClass=1A"
    When user makes a request to view student IDs
    When user makes a request to view details of a student ID
    Then user should get the response code 200
