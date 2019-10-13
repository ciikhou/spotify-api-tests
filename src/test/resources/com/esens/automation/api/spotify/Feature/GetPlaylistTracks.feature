Feature: Get Playlist Tracks
  Description: Get Playlist Tracks By Id and FailTest

    Scenario: Get a Playlist Tracks
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Get Playlist Tracks
    Then My request GET Playlist Tracks should return code 200
    And My GET Playlist Tracks Response Body Should Contains "name" : "Manhattan-Kaboul"






