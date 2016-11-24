package com.singuloid.rxjava.advanced.volley;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 * <p>
 * The helper class of which is used to provide references to initialized RequestQueue and ImageLoader
 */
public class MyVolley {

    private static RequestQueue mRequestQueue;

    private MyVolley() {

    }

    /**
     * Init the volley.
     * @param context here the context of which using to init the {@link Volley#newRequestQueue(Context)}
     *                should be the instance of {@link Application#getApplicationContext()},
     *                not the instance of Activity Context.
     *                As the volley request queue will be last in the app lifecycle for a long
     *                time.
     */
    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null)
            return mRequestQueue;
        else
            throw new IllegalStateException("RequestQueue not initialized ");
    }


}
