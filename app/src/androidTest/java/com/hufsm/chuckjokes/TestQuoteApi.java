package com.hufsm.chuckjokes;

import com.hufsm.chuckjokes.domain.Quote;
import com.hufsm.chuckjokes.domain.QuoteApi;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.mock.Calls;

/**
 * Created by sclev on 8/1/2017.
 */
@Singleton
public class TestQuoteApi implements QuoteApi {

    private String nextQuote = "inital quote";

    @Inject
    public TestQuoteApi() {

    }

    public void setNextQuote(String quote) {
        nextQuote = quote;
    }

    @Override
    public Call<Quote> getRandomQuote() {
        return Calls.defer(new Callable<Call<Quote>>() {
            @Override
            public Call<Quote> call() throws Exception {
                Quote quote = new Quote();
                quote.value = nextQuote;
                return Calls.response(quote);
            }
        });
    }

}
