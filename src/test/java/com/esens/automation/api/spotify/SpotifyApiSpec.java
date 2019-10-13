package com.esens.automation.api.spotify;

import com.esens.automation.api.spotify.TestDatas.TestsDatas;
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

    public String accessToken = getAccessToken();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

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
        chromeOptions.setHeadless(true);
        chromeOptions.setCapability("chrome.switches","--incognito");
        chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
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
