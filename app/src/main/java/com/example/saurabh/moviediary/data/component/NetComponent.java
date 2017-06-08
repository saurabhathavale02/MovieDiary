package com.example.saurabh.moviediary.data.component;

import com.example.saurabh.moviediary.data.module.AppModule;
import com.example.saurabh.moviediary.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by saura on 5/9/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent
{
    Retrofit retrofit();

}
