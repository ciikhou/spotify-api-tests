Feature: Get Artist
  Description: Get Artist By Id and FailTest

    Scenario: Get a Artist Failtest
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Artist by a not valide id
    Then My request GET Artist should return code 400

    Scenario: Get a Artist
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a Artist by id
    Then My request GET Artist should return code 200
    And My GET Artist Response Body Should Contains "name" : "Fugees"






