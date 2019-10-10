package com.esens.automation.api.spotify;

class TestsDatas{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static final String USER_AGENT = "Mozilla/5.0";
    static final String PREFIXE_URL = "https://api.spotify.com/v1/";


    // Liste des URIS de test
    public String GET_ARTIST_ENDPOINT(String ID) {return "artists/" + ID;}
    public String GET_ALBUM_ENDPOINT(String ID) {return "albums/" + ID;}
    public String GET_PLAYLIST_ENDPOINT(String ID) {return "playlists/" + ID;}
    public String GET_PLAYLIST_TRACKS_ENDPOINT(String ID) {return "playlists/" + ID + "/tracks" ;}
    public String GET_TRACK_ENDPOINT(String ID) {return  "tracks/" + ID;}
    public String GET_LIST_OF_CURENT_USER_PLAYLIST_ENDPOINT() {return  "me/playlists";}

    public String CREATE_PLAYLIST_ENDPOINT() {return  "users/"  + userID + "/playlists";}
    public String ADD_TRACKS_TO_PLAYLIST_ENDPOINT(String ID) {return  "playlists/" + ID +"/tracks";}
    public String CHANGE_TO_PLAYLIST_DETAILS_ENDPOINT(String ID) {return  "playlists/" + ID ;}

    public String clientID = "14ad74980cc24ecb9aff88ded35986e8";

    public String loginUserName = "esensqatraining@yopmail.com";
    public String loginPassword = "Passwd1!";

    public String userID = "2g5o4vq6ayxp9eo5xlqw6os2k";

    public String trackID = "0Q0IVlqMV64kNLlwjPj0Hl";
    public String artistID = "2WKdxPFRD7IqZvlIAvhMgY";
    public String albumID = "18XFe4CPBgVezXkxZP6rTb";

    public String myPlaylistID = "1cZirM1Yv7bcx9nj2ZDNOo";

    public String newPlaylistName = "NewPlaylistCucumber";

    public String newNameForChangePlaylistDetail = "name=Playlist for test - OOoooOO";

    public String tracksUris = "uris=spotify:track:0Q0IVlqMV64kNLlwjPj0Hl,spotify:track:7eJdx83TiKsVqAzLFBelMO";
}
