package com.vectoscalar.sportsinfo.Common;

import android.app.Application;
import android.content.res.AssetManager;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Manoj on 4/19/2016.
 */
public class SPIApplication extends Application {

    public static AssetManager spiAssetManager;
    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        spiAssetManager = getAssets();
    }
}
