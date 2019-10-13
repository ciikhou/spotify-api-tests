package com.esens.automation.api.spotify;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/esens/automation/api/spotify/Feature/AccessToken.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/GetPlaylist.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/GetPlaylistTracks.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/CreatePlaylist.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/AddTrackToPlaylist.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/GetArtist.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/GetAlbum.feature",
                    "src/test/resources/com/esens/automation/api/spotify/Feature/GetTrack.feature"},
        plugin = { "pretty", "html:target/" },
        monochrome = true
)
public class RunCucumberTest {
}

