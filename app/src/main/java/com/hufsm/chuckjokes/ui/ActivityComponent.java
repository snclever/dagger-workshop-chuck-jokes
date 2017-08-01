package com.hufsm.chuckjokes.ui;

import com.hufsm.chuckjokes.presentation.RandomQuotePresenter;

import dagger.Subcomponent;

/**
 * Created by sclev on 8/1/2017.
 */

@ActivityScope
@Subcomponent
public interface ActivityComponent {

    RandomQuotePresenter getRandomQuotePresenter();

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
        ActivityComponent build();
    }
}
