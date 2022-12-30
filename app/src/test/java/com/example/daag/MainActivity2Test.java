package com.example.daag;


import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import com.example.daag.ui.MainActivity;
import com.example.daag.ui.MainActivity2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivity2Test {

    MainActivity2 activity;
    MainActivity mainActivity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity2.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void setActivity() {
        assertNotNull(activity);
    }

    @Test
    public void checkTestViewNotNull() {
        TextView tvTitle = activity.findViewById(R.id.tvTitle);
        TextView tvDes = activity.findViewById(R.id.tvDes);

        assertNotNull("tTvTitle could not be found", tvTitle.getText().toString());
        assertNotNull("tvDes could not be found", tvDes.getText().toString());
    }

    @Test
    public void backActivity() {
        activity.onBackPressed();
        assertNotNull(MainActivity.class);
    }
}
