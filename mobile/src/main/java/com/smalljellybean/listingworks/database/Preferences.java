package com.smalljellybean.listingworks.database;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static final String SHARED_PREFERENCE_FILE_NAME = "com.smalljellybean.listingworks";
    public static final String USER_ID = "USER_ID";
    public static final String USERNAME = "USERNAME";
    public static final String SESSION_TOKEN = "SESSION_TOKEN";

    private SharedPreferences sharedPreferences;
    private static Preferences preferences;

    public static Preferences getInstance(Context context) {
        if (preferences == null) {
            preferences = new Preferences(context);
        }
        return preferences;
    }

    private Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, context.MODE_PRIVATE);
    }

    public void saveProperty(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getProperty(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void saveUserId(String id) {
        saveProperty(USER_ID, id);
    }

    public String getUserId() {
        return getProperty(USER_ID);
    }

    public void saveToken(String token) {
        saveProperty(SESSION_TOKEN, token);
    }

    public String getSessionToken() {
        return getProperty(SESSION_TOKEN);
    }

    public void saveUsername(String username) {
        saveProperty(USERNAME, username);
    }

    public String getUsername() {
        return getProperty(USERNAME);
    }

}
