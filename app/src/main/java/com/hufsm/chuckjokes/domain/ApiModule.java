package com.hufsm.chuckjokes.domain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by sclev on 8/1/2017.
 */

@Module
public abstract class ApiModule {

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    public static QuoteApi provideQuoteApi(Retrofit retrofit) {
        return retrofit.create(QuoteApi.class);
    }


}
