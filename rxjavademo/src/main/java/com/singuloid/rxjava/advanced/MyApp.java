package com.singuloid.rxjava.advanced;

import android.app.Application;

import com.singuloid.rxjava.advanced.volley.MyVolley;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 */
public class MyApp extends Application {

    private static MyApp sInstance;

    private RefWatcher mRefWatcher;

    public static MyApp getApp() {
        return sInstance;
    }

    public static RefWatcher getRefWatcher() {
        return MyApp.getApp().mRefWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = (MyApp) getApplicationContext();
        mRefWatcher = LeakCanary.install(this);

        MyVolley.init(this);

        Timber.plant(new Timber.DebugTree());
    }
}
