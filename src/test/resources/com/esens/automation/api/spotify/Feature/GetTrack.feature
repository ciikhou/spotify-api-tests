Feature: Get Track
  Description: Get Track By Id and FailTest

    Scenario: Get a Track Failtest
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Track by a not valide id
    Then My request GET Track should return code 400

    Scenario: Get a Track
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Track by id
    Then My request GET Track should return code 200
    And My GET Track Response Body Should Contains "name" : "Killing Me Softly With His Song"






