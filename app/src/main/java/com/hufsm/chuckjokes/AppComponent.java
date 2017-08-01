package com.hufsm.chuckjokes;

import com.hufsm.chuckjokes.domain.ApiModule;
import com.hufsm.chuckjokes.domain.DomainModule;
import com.hufsm.chuckjokes.ui.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sclev on 8/1/2017.
 */
@Singleton
@Component(modules = {
        DomainModule.class,
        ApiModule.class
})
public interface AppComponent {

    ActivityComponent.Builder getActivityComponentBuilder();

}
