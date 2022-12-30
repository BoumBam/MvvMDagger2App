package com.example.daag.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.daag.R;
import com.example.daag.databinding.ActivityMain2Binding;
import com.example.daag.model.TestData;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActivityMain2Binding activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);


        Intent i = getIntent();
        TestData testData = new TestData(i.getStringExtra("name"), i.getStringExtra("description"));

        Log.d("TOG", "onCreate: "+i.getStringExtra("name"));
        Log.d("TOG", "onCreate: "+i.getStringExtra("description"));

        activityMain2Binding.setTestData(testData);
    }
}