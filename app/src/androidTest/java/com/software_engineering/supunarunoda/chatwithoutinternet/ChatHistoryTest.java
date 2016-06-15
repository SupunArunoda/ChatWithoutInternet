package com.software_engineering.supunarunoda.chatwithoutinternet;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
/**
 * Created by Supun on 6/15/2016.
 */
public class ChatHistoryTest {
    @Rule
    public ActivityTestRule<ChatHistoryActivity> activityTestRule =
            new ActivityTestRule<>(ChatHistoryActivity.class);

    @Test
    public void clickOnItemWithTextEqualToMyFirst() {
        // Find the adapter position to click based on matching the text "two" to the adapter item's text
        onData(allOf(is(instanceOf(String.class)), is("MyFirst"))) // Use Hamcrest matchers to match item
                .inAdapterView(withId(R.id.chat_history)) // Specify the explicit id of the ListView
                .perform(click()); // Standard ViewAction
    }

}
