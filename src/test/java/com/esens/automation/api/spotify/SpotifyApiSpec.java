package com.esens.automation.api.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpotifyApiSpec extends TestsDatas {

    String accessToken = getAccessToken();

    public void getAlbumById(String albumID){
        sendRequest("GET",GET_ALBUM_ENDPOINT(albumID),null);
    }

    public void getPlaylistTracksById(String PlaylistID){
        sendRequest("GET",GET_PLAYLIST_TRACKS_ENDPOINT(PlaylistID),null);
    }

    public void getTrackById(String TrackID){
        sendRequest("GET",GET_TRACK_ENDPOINT(TrackID),null);
    }

    public void getArtistById(String arstistID){
        sendRequest("GET",GET_ARTIST_ENDPOINT(artistID),null);
    }

    public void getMyCurrentUsersPlaylisst(){
        sendRequest("GET",GET_LIST_OF_CURENT_USER_PLAYLIST_ENDPOINT(),null);
    }

    public void ChangePlaylistDetails(String PlaylistId, String POST_PARAMETERS){
        sendRequest("PUT",CHANGE_TO_PLAYLIST_DETAILS_ENDPOINT(PlaylistId),POST_PARAMETERS);
    }

    public void AddTracksToPlaylist(String PlaylistID, String Uris){
        sendRequest("POST",ADD_TRACKS_TO_PLAYLIST_ENDPOINT(PlaylistID),Uris);
    }

    public void CreatePlaylist(String POST_PARAMETERS){
        sendRequest("POST",CREATE_PLAYLIST_ENDPOINT(),POST_PARAMETERS);
    }

    public String getAccessToken() {
        try {
            Scanner scanner = new Scanner( new File("temp/authorization/current_access_token.txt"), "UTF-8");
            String text = scanner.useDelimiter("\\A").next();
            return text;
        } catch (FileNotFoundException e){
            e.getMessage();
            e.printStackTrace();
            }
            return "OOooOO";
    }

    public String getChromeDriverFilePath() {
        String pathPrefixe = "src/test/resources/bin/";
        if (System.getProperty("os.name").startsWith("Windows"))
            return pathPrefixe + "chromedriver.exe";
        else
            return pathPrefixe + "chromedriver";
    }


    public ChromeOptions getChromeOptions() {
        System.setProperty("webdriver.chrome.driver",getChromeDriverFilePath());
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.setCapability("chrome.switches","--incognito");
        chromeOptions.addArguments("--kiosk");
        return chromeOptions;
    }

    public void checkAccessToken() {
        try {
            Assert.assertNotNull(accessToken);
            System.out.println(ANSI_GREEN + "\n Access-Token was find by retrieving the get parameter 'access_token' from the url (Selenium)" + ANSI_RESET);
        } catch (AssertionError error){
            System.out.println(ANSI_RED + error.getMessage() + ANSI_RESET);
        }
    }

    public Response sendRequest(String Type, String urlEndpoint, String PostOrPutParameters) {
        System.out.println(Type + " REQUEST :" + PREFIXE_URL + urlEndpoint );
        RestAssured.baseURI = PREFIXE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("User-Agent", USER_AGENT);
        request.header("Authorization", "Bearer "+ accessToken);
        if (Type == "GET"){
            try {
                Response response = request.get(urlEndpoint);
                return response;
            } catch(Exception e){
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            }
        } else {
            JSONObject requestParams = new JSONObject();
            String[] couple = PostOrPutParameters.split("&");
            for( String keyAndValue : couple) {
                requestParams.put(keyAndValue.split("=")[0],keyAndValue.split("=")[1]);
            }
            request.body(requestParams.toString());
            if (Type == "POST"){
                try {
                    Response response = request.post( urlEndpoint + "?" + PostOrPutParameters);
                    return response;
                } catch(Exception e){
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                }
            }
            if (Type == "PUT"){
                try {
                    Response response = request.put( urlEndpoint + "?" + PostOrPutParameters);
                    return response;
                } catch(Exception e){
                    System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                }
            }
        }
        return null;
    }
}
