package com.hufsm.chuckjokes;

import com.hufsm.chuckjokes.domain.Quote;
import com.hufsm.chuckjokes.domain.QuoteApi;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sclev on 8/1/2017.
 */
@Module
public abstract class TestApiModule {

    @Binds
    @Singleton
    public abstract QuoteApi bindQuoteApi(TestQuoteApi impl);

}
