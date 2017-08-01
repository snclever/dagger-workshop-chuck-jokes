package com.hufsm.chuckjokes;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.hufsm.chuckjokes.ui.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class,
            true,
            false
    );

    TestQuoteApi testQuoteApi;

    @Before
    public void setUp() throws Exception {
        activityTestRule.launchActivity(null);

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        TestApplication application = (TestApplication) instrumentation.getTargetContext().getApplicationContext();

        testQuoteApi = ((TestAppComponent) application.getAppComponent()).testQuoteApi();
    }

    @Test
    public void testQuote() throws Exception {
        // given
        testQuoteApi.setNextQuote("some funny joke");

        // when
        onView(withId(R.id.next)).perform(click());

        // then
        onView(withId(R.id.quote)).check(matches(withText("some funny joke")));
    }
}
