package com.esens.automation.api.spotify.StepDefinitions;

import com.esens.automation.api.spotify.SpotifyApiSpec;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthorizationSteps extends SpotifyApiSpec {

    private String accessToken;
    private ChromeOptions chromeOptions;
    private ChromeDriver chromeDriver;

    @Given("I Set ChromeDriver Options")
    public void set_chromeDriver_options(){
        this.chromeOptions = getChromeOptions();
    }

    @And("I start WebDriver")
    public void start_web_driver(){
        this.chromeDriver = new  ChromeDriver(chromeOptions);
    }

    @And("I'm connect to Spotify by credentials")
    public void connect_spotify(){
        chromeDriver.get("https://accounts.spotify.com/authorize?client_id=" + clientID +"&response_type=token&redirect_uri=http://www.example.com/postman/redirect&state=123&scope=playlist-modify&show_dialog=false");
        chromeDriver.findElement(By.id("login-username")).sendKeys(loginUserName);
        chromeDriver.findElement(By.id("login-password")).sendKeys(loginPassword);
        chromeDriver.findElement(By.id("login-button")).click();
        }

    @And("Get AccessToken")
    public void get_access_token_and_set_it(){
        try {Thread.sleep(3000);} catch(InterruptedException e){System.out.println("Tiemout error !");}
        String myACtualURL = chromeDriver.executeScript("return window.location.href").toString();
        this.accessToken = myACtualURL.split("access_token=")[1].split("&token_type")[0];
    }

    @And("Quit Browser")
    public void quit_browser(){
        chromeDriver.close();
    }

    @Then("Save my 'access_token'")
    public void save_my_access_token(){
        try{
            File directory = new File("temp/authorization");
            if (! directory.exists()){
                directory.mkdirs();
            }
            String data = this.accessToken;
            FileOutputStream out = new FileOutputStream("temp/authorization/current_access_token.txt");
            out.write(data.getBytes());
            out.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
        }
    }
}