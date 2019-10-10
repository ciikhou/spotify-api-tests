Feature: Add Access Token Authorization - Get Access Token
  Description: Add Access Token in url with Selenium WebDriver

    Scenario: Get Access Token
    Given I Set ChromeDriver Options
    And I start WebDriver
    And I'm connect to Spotify by credentials
    And Get AccessToken
    And Quit Browser
    Then Save my 'access_token'







