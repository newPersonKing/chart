package com.temp.chart;

import android.app.Application;

import com.temp.chart.utils.DaoUntils;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaoUntils.initGreenDao(this);
    }
}
