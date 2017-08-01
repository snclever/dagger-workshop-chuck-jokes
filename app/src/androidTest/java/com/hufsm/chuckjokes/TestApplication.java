package com.hufsm.chuckjokes;

import com.hufsm.chuckjokes.ui.MainActivity;

/**
 * Created by sclev on 8/1/2017.
 */

public class TestApplication extends MainApplication {

    private TestAppComponent testAppComponent;

    @Override
    public AppComponent getAppComponent() {
        if (testAppComponent == null) {
            testAppComponent = DaggerTestAppComponent.create();
        }
        return testAppComponent;
    }
}
