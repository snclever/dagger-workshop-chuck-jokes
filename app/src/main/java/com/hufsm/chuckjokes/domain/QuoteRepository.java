package com.hufsm.chuckjokes.domain;

/**
 * Created by sclev on 8/1/2017.
 */

public interface QuoteRepository {

    void getQuote(QuoteListener listener);

    interface QuoteListener {
        void onLoading();

        void onNewQuote(String quote);

        void onError();
    }

}
