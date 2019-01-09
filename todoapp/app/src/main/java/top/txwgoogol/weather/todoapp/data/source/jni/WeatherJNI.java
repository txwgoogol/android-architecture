package top.txwgoogol.weather.todoapp.data.source.jni;

public class WeatherJNI {

    static {
        System.loadLibrary("weather");
    }

    public static native String weatherKey();
}
