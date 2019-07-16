package com.example.todomvvm.data.source.remote

import com.example.todomvvm.data.entity.Now
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiStore {

	//实况天气
	@GET("weather/now")
	fun now(@Query("location") location: String): Call<Now>

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