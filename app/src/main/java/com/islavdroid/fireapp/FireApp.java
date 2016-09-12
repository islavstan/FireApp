package com.islavdroid.fireapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by islav on 12.09.2016.
 */
public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
