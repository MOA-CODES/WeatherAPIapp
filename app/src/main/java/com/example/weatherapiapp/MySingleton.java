package com.example.weatherapiapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
//hmm
public class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;

    private static Context ctx;
    //the singleton handles multiple things happening at the same time in sequential order from different activties

    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }//BRO

    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {//instance is does this exist already
            instance = new MySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}