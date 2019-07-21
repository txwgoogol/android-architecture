package com.example.todomvvm.data.source.remote

import com.example.todomvvm.data.bean.*
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//接口
interface ApiStore {

    //实况天气
    @GET("weather/now")
    fun now(@Query("location") location: String): Call<HeWeather6<WeatherNow>>

    //逐小时预报
    @GET("weather/hourly")
    fun hourly(@Query("location") location: String): Call<HeWeather6<List<WeatherHourly>>>

    //七天预报
    @GET("weather/forecast")
    fun forecast(@Query("location") location: String): Call<HeWeather6<List<WeatherForecast>>>

    //生活指数
    @GET("weather/lifestyle")
    fun lifestyle(@Query("location") location: String): Call<HeWeather6<List<WeatherLifeStyle>>>

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
                .build()
                .create(ApiStore::class.java)
        }
    }

}