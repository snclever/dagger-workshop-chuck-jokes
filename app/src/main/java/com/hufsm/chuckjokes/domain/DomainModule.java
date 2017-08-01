package com.hufsm.chuckjokes.domain;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sclev on 8/1/2017.
 */
@Module
public abstract class DomainModule {

    @Binds
    @Singleton
    public abstract QuoteRepository bindQuoteRepository(QuoteRepositoryImpl impl);


}
