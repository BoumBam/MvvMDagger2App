package com.example.daag.di;

import com.example.daag.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

    public void inject(MainActivityViewModel mainActivityViewModel);
}
