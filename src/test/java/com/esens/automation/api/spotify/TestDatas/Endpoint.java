package com.esens.automation.api.spotify.TestDatas;

public class Endpoint {
    public static String GET_ARTIST(String ID) {return "artists/" + ID;}
    public static String GET_ALBUM(String ID) {return "albums/" + ID;}
    public static String GET_PLAYLIST(String ID) {return "playlists/" + ID;}
    public static String GET_PLAYLIST_TRACKS(String ID) {return "playlists/" + ID + "/tracks" ;}
    public static String GET_TRACK(String ID) {return  "tracks/" + ID;}
    public static String GET_LIST_OF_CURENT_USER_PLAYLIST() {return  "me/playlists";}

    public static String CREATE_PLAYLIST(String ID) {return  "users/"  + ID + "/playlists";}
    public static String ADD_TRACKS_TO_PLAYLIST(String ID) {return  "playlists/" + ID +"/tracks";}
    public static String CHANGE_TO_PLAYLIST_DETAILS(String ID) {return  "playlists/" + ID ;}

}
