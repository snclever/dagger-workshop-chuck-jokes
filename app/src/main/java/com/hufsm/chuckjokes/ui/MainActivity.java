package com.hufsm.chuckjokes.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hufsm.chuckjokes.MainApplication;
import com.hufsm.chuckjokes.R;
import com.hufsm.chuckjokes.presentation.RandomQuotePresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements RandomQuotePresenter.View {

    private ActivityComponent activityComponent;

    @Inject
    RandomQuotePresenter presenter;

    private TextView quoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityComponent = ((MainApplication) getApplication()).getAppComponent().getActivityComponentBuilder().build();
        activityComponent.inject(this);

        presenter.setView(this);

        quoteTextView = (TextView) findViewById(R.id.quote);
        Button nextQuoteButton = (Button) findViewById(R.id.next);
        nextQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.nextQuote();
            }
        });
    }

    @Override
    public void showLoading() {
        quoteTextView.setText("...");
    }

    @Override
    public void showQuote(String quote) {
        quoteTextView.setText(quote);
    }

    @Override
    public void showError() {
        quoteTextView.setText("Error occurred!");
    }
}
