package com.esens.automation.api.spotify.StepDefinitions;

import com.esens.automation.api.spotify.SpotifyApiSpec;
import com.esens.automation.api.spotify.TestDatas.Endpoint;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;


public class PlaylistSteps extends SpotifyApiSpec {

    private Response myRequestResponse ;

    @And("Execute My Request : Get a playlist by id")
    public void get_playlist_by_id(){
       this.myRequestResponse = sendRequest("GET",Endpoint.GET_PLAYLIST(myPlaylistID),null);
    }
    @And("Execute My Request : Add Track To Playlist")
    public void add_track_to_playlist_by_id(){
        this.myRequestResponse = sendRequest("POST",Endpoint.ADD_TRACKS_TO_PLAYLIST(myPlaylistID),tracksUris);
    }

    @Then("My request GET Playlist should return code (.*)")
    public void my_request_get_playlist_should_retrun_expected_code(int int1) {
        Assert.assertEquals(myRequestResponse.getStatusCode(),int1);
        System.out.println( ANSI_GREEN + "The excpected code is good => " + int1 + ANSI_RESET);
    }

    @Then("My request Add Track To Playlist should return code (.*)")
    public void my_request_add_track_to_playlist_should_retrun_expected_code(int int1) {
        Assert.assertEquals(myRequestResponse.getStatusCode(),int1);
        System.out.println( ANSI_GREEN + "The excpected code is good => " + int1 + ANSI_RESET);
    }

    @And("My GET Playlist Response Body Should Contains (.*)")
    public void verify_my_body_content(String arg1){
        Assert.assertEquals(myRequestResponse.getBody().print().contains(arg1),true);
        System.out.println( ANSI_GREEN + "My respnse body contain 'display_name': 'QA Training'" + ANSI_RESET);
    }




    // Creation
    @And("Execute My Request : Create playlist")
    public void create_playlist(){
        myRequestResponse = sendRequest("POST",Endpoint.CREATE_PLAYLIST(userID),"name=oooooooooo&description=hh" );
    }

    @Then("My request Create Playlist should return code (.*)")
    public void my_request_create_playlist_should_retrun_expected_code(int int1) {
        Assert.assertEquals(myRequestResponse.getStatusCode(),int1);
        System.out.println( ANSI_GREEN + "The excpected code is good => " + int1 + ANSI_RESET);
    }

    // Get Playlist FailTest

    @And("Execute My Request : Get a playlist by a not valide id")
    public void get_playlist_by_a_not_valide_id(){
        myRequestResponse = sendRequest("GET",Endpoint.GET_PLAYLIST("badIdForFailTest"),null);
    }


}
