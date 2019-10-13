package com.esens.automation.api.spotify.StepDefinitions;

import com.esens.automation.api.spotify.SpotifyApiSpec;
import cucumber.api.java.en.Given;

public class _CommonSteps extends SpotifyApiSpec {

    @Given("I have a valid 'Access Token' for running tests")
    public void check_my_access_token(){
        checkAccessToken();
    }}
