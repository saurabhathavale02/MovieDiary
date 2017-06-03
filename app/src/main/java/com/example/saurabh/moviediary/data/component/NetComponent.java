package com.example.saurabh.moviediary.data.component;

import com.example.saurabh.moviediary.data.module.AppModule;
import com.example.saurabh.moviediary.data.module.NetModule;
import com.example.saurabh.moviediary.screen.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saura on 5/9/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent
{
    void inject(MainActivity activity);

}
