package com.example.android.architecture.blueprints.todoapp.data.source.remote;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptorEx implements Interceptor {

    private static final String TAG = "InterceptorEx";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //请求前--打印请求信息
        long t1 = System.nanoTime();
        Log.d(TAG, String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        //网络请求
        Response response = chain.proceed(request);

        //网络响应后--打印响应信息
        long t2 = System.nanoTime();
        Log.d(TAG, String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }

}