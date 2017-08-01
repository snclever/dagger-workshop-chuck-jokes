package com.hufsm.chuckjokes.presentation;

import com.hufsm.chuckjokes.domain.QuoteRepository;
import com.hufsm.chuckjokes.ui.ActivityScope;

import javax.inject.Inject;

/**
 * Created by sclev on 8/1/2017.
 */
@ActivityScope
public class RandomQuotePresenter {

    private QuoteRepository quoteRepository;

    private View view;

    @Inject
    public RandomQuotePresenter(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nextQuote() {
        quoteRepository.getQuote(new QuoteRepository.QuoteListener() {
            @Override
            public void onLoading() {
                view.showLoading();
            }

            @Override
            public void onNewQuote(String quote) {
                view.showQuote(quote);
            }

            @Override
            public void onError() {
                view.showError();
            }
        });
    }

    public interface View {
        void showLoading();

        void showQuote(String quote);

        void showError();
    }

}
