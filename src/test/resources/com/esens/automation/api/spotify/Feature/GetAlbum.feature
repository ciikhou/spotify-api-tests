Feature: Get Album
  Description: Get Album By Id and FailTest

    Scenario: Get a Album Failtest
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Album by a not valide id
    Then My request GET Album should return code 400

    Scenario: Get a Album
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Album by id
    Then My request GET Album should return code 200
    And My GET Album Response Body Should Contains "name" : "Killing Me Softly With His Song"






