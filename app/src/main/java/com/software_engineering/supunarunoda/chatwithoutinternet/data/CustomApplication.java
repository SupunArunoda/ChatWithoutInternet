package com.software_engineering.supunarunoda.chatwithoutinternet.data;

import android.app.Application;
import android.content.Context;

/**
 * Created by Supun on 6/13/2016.
 */

//class for context activity for DB access
public class CustomApplication extends Application {
    private static Context context;
    public void onCreate(){
        context=getApplicationContext();
    }

    public static Context getCustomAppContext(){
        return context;
    }
}
