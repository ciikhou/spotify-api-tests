Feature: Get Playlist
  Description: Get Playlist By Id and FailTest

    Scenario: Get a Playlist Failtest
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a playlist by a not valide id
    Then My request GET Playlist should return code 404

    Scenario: Get a Playlist
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get a playlist by id
    Then My request GET Playlist should return code 200
    And My GET Playlist Response Body Should Contains "display_name" : "QA Training"






