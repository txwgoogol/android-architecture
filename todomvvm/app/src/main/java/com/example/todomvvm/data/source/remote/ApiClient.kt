package com.example.todomvvm.data.source.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author txw
 * 数据请求
 */
class ApiClient {

    private lateinit var mRetrofit: Retrofit

    companion object {
        private const val DEFAULT_TIME_OUT = 5L//超时时间 5s
        private const val DEFAULT_READ_TIME_OUT = 10L
    }

    fun ApiClient() {
        // 创建 OKHttpClient
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//读操作超时时间
        // 创建Retrofit
        mRetrofit = Retrofit.Builder()
            .baseUrl("")
            .client(builder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private object SingleHolder {
        val INSTANCE = ApiClient()
    }

    fun getInstance(): ApiClient {
        return SingleHolder.INSTANCE
    }

    //获取对应的接口 映射？
    fun <T> create(cls: Class<T>): T {
        return mRetrofit.create(cls)
    }

}