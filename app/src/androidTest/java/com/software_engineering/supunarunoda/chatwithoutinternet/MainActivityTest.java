package com.software_engineering.supunarunoda.chatwithoutinternet;


import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;

import static android.app.PendingIntent.getActivity;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Supun on 6/15/2016.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateUserName() {
        onView(withId(R.id.userName)).perform(typeText("John")).check(matches(withText("John")));
    }
    @Test
    public void validateChatName() {
        onView(withId(R.id.chatName)).perform(typeText("Chat Room")).check(matches(withText("Chat Room")));
    }
}
