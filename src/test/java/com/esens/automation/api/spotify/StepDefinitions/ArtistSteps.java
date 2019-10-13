package com.esens.automation.api.spotify.StepDefinitions;

import com.esens.automation.api.spotify.SpotifyApiSpec;
import com.esens.automation.api.spotify.TestDatas.Endpoint;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class ArtistSteps extends SpotifyApiSpec {

    private Response myRequestResponse ;

    @And("Execute My Request : Get a Artist by id")
    public void get_artist_by_id(){
       this.myRequestResponse = sendRequest("GET", Endpoint.GET_ARTIST(artistID),null);
    }

    @Then("My request GET Artist should return code (.*)")
    public void my_request_get_Artist_should_retrun_expected_code(int int1) {
        Assert.assertEquals(myRequestResponse.getStatusCode(),int1);
        System.out.println( ANSI_GREEN + "The excpected code is good => " + int1 + ANSI_RESET);
    }

    @And("My GET Artist Response Body Should Contains (.*)")
    public void verify_my_body_content(String arg1){
        Assert.assertEquals(myRequestResponse.getBody().print().contains(arg1),true);
        System.out.println( ANSI_GREEN + "My respnse body contain 'display_name': 'QA Training'" + ANSI_RESET);
    }

    @Then("My request Create Artist should return code (.*)")
    public void my_request_create_Artist_should_retrun_expected_code(int int1) {
        Assert.assertEquals(myRequestResponse.getStatusCode(),int1);
        System.out.println( ANSI_GREEN + "The excpected code is good => " + int1 + ANSI_RESET);
    }

    // Get Artist FailTest
    @And("Execute My Request : Get a Artist by a not valide id")
    public void get_artist_by_a_not_valide_id(){
        myRequestResponse = sendRequest("GET",Endpoint.GET_ARTIST("BadIdForFailTest"),null);
    }


}
