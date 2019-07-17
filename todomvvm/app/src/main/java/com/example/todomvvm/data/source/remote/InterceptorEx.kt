package com.example.todomvvm.data.source.remote

import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

//拦截器
class InterceptorEx : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        //添加公共请求头
//        Request request = chain.request().newBuilder()
//                //.header("User-Agent", "YourAppName")
//                //.header("Accept", "application/vnd.yourapi.v1.full+json")
//                .header("key","52zpuzgswyulc0w6")
//                .method(original.method(), original.body())
//                .build();

        //添加公共参数
        val request: Request
        val modifiedUrl = original.url().newBuilder()
            .addQueryParameter("key", "36860e998a3f46faaac9bf2d160a4a97")//WeatherJNI.weatherKey()
            .build()
        request = original.newBuilder().url(modifiedUrl).build()

        //请求前--打印请求信息
        val t1 = System.nanoTime()
        Logger.d(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()))

        //网络请求
        val response = chain.proceed(request)

        //网络响应后--打印响应信息
        val t2 = System.nanoTime()
        Logger.d(
            String.format(
                "Received response for %s in %.1fms%n%s",
                response.request().url(),
                (t2 - t1) / 1e6,
                response.headers()
            )
        )
        return response
    }

}