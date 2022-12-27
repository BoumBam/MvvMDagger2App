package com.example.daag;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivity2Test {


    @Rule
    public ActivityScenarioRule<MainActivity2> activityScenarioRule = new ActivityScenarioRule<>(MainActivity2.class);



    @Test
    public void activityIsVisible2() {
        onView(withId(R.id.recyclerView2))
                .check(matches(isDisplayed()));
    }
}
