package com.example.android.architecture.blueprints.todoapp.jni;

public class WeatherJNI {

    static {
        System.loadLibrary("weather");
    }

    public static native String weatherKey();
}
