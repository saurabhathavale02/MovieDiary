package com.example.saurabh.moviediary;

import android.app.Application;

import com.example.saurabh.moviediary.data.classes.ResultData;
import com.example.saurabh.moviediary.data.component.DaggerNetComponent;
import com.example.saurabh.moviediary.data.component.NetComponent;
import com.example.saurabh.moviediary.data.module.AppModule;
import com.example.saurabh.moviediary.data.module.NetModule;

/**
 * Created by saura on 5/9/2017.
 */

public class App extends Application
{
    public ResultData restaurantData;
    private NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://maps.googleapis.com/maps/api/place/nearbysearch/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
