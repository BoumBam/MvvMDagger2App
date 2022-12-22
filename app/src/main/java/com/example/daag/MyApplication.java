package com.example.daag;

import android.app.Application;

import com.example.daag.di.DaggerRetroComponent;
import com.example.daag.di.RetroComponent;
import com.example.daag.di.RetroModule;

public class MyApplication  extends Application {

    private RetroComponent retroComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule())
                .build();
    }

    public RetroComponent getRetroComponent() {
        return retroComponent;
    }
}
