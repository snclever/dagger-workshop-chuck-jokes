package com.hufsm.chuckjokes.domain;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sclev on 8/1/2017.
 */

public interface QuoteApi {

    @GET("jokes/random")
    Call<Quote> getRandomQuote();

}
