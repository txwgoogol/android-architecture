package com.example.todomvvm.data.source.remote

import com.example.todomvvm.data.bean.*
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//接口
interface ApiStore {

    //实况天气
    @GET("weather/now")
    fun now(@Query("location") location: String): Call<WeatherNow>

    //实况天气 - 1
//    @GET("weather/now")
//    fun nowStr(@Query("location") location: String): Call<ResponseBody>

    //逐小时预报
    @GET("weather/hourly")
    fun hourly(@Query("location") location: String): Call<WeatherHourly>

    //逐小时预报 - 1
//    @GET("weather/hourly")
//    fun hourlyStr(@Query("location") location: String): Call<ResponseBody>

    //七天预报
    @GET("weather/forecast")
    fun forecast(@Query("location") location: String): Call<WeatherForecast>

    //七天预报 - 1
//    @GET("weather/forecast")
//    fun forecastStr(@Query("location") location: String): Call<ResponseBody>

    //生活指数
    @GET("weather/lifestyle")
    fun lifestyle(@Query("location") location: String): Call<WeatherLifeStyle>

    //生活指数 - 1
//    @GET("weather/lifestyle")
//    fun lifestyleStr(@Query("location") location: String): Call<ResponseBody>

    companion object {
        private const val BASE_URL = "https://free-api.heweather.net/s6/"
        fun create(): ApiStore = create(HttpUrl.parse(BASE_URL)!!)
        private fun create(httpUrl: HttpUrl): ApiStore {

//			val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
//				Log.d("API", it)
//			})
//			logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(InterceptorEx())
                .build()

            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiStore::class.java)
        }
    }

}