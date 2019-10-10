package com.esens.automation.api.spotify.Runner.PlaylistTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/esens/automation/api/spotify/Feature/GetPlaylist.feature"},
        glue  = {"com.esens.automation.api.spotify.StepDefinitions"},
        plugin = {"pretty"}
)
public class RunGetPlaylistTest {
}

