Feature: Add Track To Playlist
  Description: Add Track To Playlist

    Scenario: Add Track To Playlist
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Add Track To Playlist
    Then My request Add Track To Playlist should return code 201




