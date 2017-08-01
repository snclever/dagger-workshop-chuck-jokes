package com.hufsm.chuckjokes.domain;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sclev on 8/1/2017.
 */

public class QuoteRepositoryImpl implements QuoteRepository {

    private QuoteApi quoteApi;

    @Inject
    public QuoteRepositoryImpl(QuoteApi quoteApi) {
        this.quoteApi = quoteApi;
    }

    @Override
    public void getQuote(final QuoteListener listener) {
        listener.onLoading();
        quoteApi.getRandomQuote().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful()) {
                    listener.onNewQuote(response.body().value);
                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                listener.onError();
            }
        });
    }
}
