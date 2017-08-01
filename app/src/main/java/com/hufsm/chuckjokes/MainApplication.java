package com.hufsm.chuckjokes;

import android.app.Application;

/**
 * Created by sclev on 8/1/2017.
 */

public class MainApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.create();
        }
        return appComponent;
    }

}
