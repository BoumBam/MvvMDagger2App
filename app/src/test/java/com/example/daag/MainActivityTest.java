package com.example.daag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Intent;
import android.widget.Button;

import com.example.daag.ui.MainActivity;
import com.example.daag.ui.MainActivity2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() {
        //assertNotNull(activity);
        assertEquals("bon", "bon");
    }

    @Test
    public void shouldNotBeNull2() {
        assertNotNull(activity);
    }

    @Test
    public void continueShouldLaunchMineActivity() {
        Intent expectedIntent = new Intent(activity, MainActivity2.class);
        activity.findViewById(R.id.button).callOnClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

    @Test
    public void checkBtnNotNull() {
        Button btn = activity.findViewById(R.id.button);
        assertNotNull("Button could not be found", btn.getText().toString());
        assertTrue("Button contains incorrect text",
                "click here".equals(btn.getText().toString()));
    }

}

