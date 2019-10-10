Feature: Create Playlist
  Description: Create Playlist

    Scenario: Create Playlist
    Given I have a valid 'Access Token' for running tests
    And Execute My Request : Create playlist
    Then My request Create Playlist should return code 201




