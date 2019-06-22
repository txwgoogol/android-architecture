package com.example.todomvvm.data.source.remote

import android.util.Log
import com.example.todomvvm.data.entity.*
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiStore {

	//获取天气信息
	@GET("adat/sk/{cityId}.html")
	fun loadDataByRetrofitRess(@Path("cityId") cityId: String): Call<Weather>

	companion object {
		private const val BASE_URL = "http://www.weather.com.cn/"
		fun create(): ApiStore = create(HttpUrl.parse(BASE_URL)!!)
		private fun create(httpUrl: HttpUrl): ApiStore {
			val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
				Log.d("API", it)
			})
			logger.level = HttpLoggingInterceptor.Level.BASIC
			
			val client = OkHttpClient.Builder()
				.addInterceptor(logger)
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