package com.example.todomvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.todomvvm.Injection
import com.example.todomvvm.R
import com.example.todomvvm.data.entity.Weather
import com.example.todomvvm.data.entity.Weatherinfoo
import com.example.todomvvm.data.source.local.ViewModelFactory
import com.example.todomvvm.data.source.local.WeatherViewModel
import com.example.todomvvm.data.source.remote.ApiStore
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
	
	lateinit var weatherViewModel: WeatherViewModel
	lateinit var viewModelFactory: ViewModelFactory
	private val disposable = CompositeDisposable()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		viewModelFactory = Injection.provideViewModelFactory(this)
		weatherViewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel::class.java)
		
		
		ApiStore.create().loadDataByRetrofitRess("101190201").enqueue(object : Callback<Weather> {
			override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
				Log.d("TAG", "成功=获取到的信息=========" + Gson().toJson(response.body()))
				//val s = response.body() as Weather
				//weather_info.text = "城市ID：" + s.weatherInfo.cityid + "\n" + "城市：" + s.weatherInfo.city + "\n" + "时间：" + s.weatherInfo.time + "\n" + "温度：" + s.weatherInfo.temp + "\n"
				insertWeather(response.body()!!.weatherinfo)
			}
			
			override fun onFailure(call: Call<Weather>, t: Throwable) {
				Log.d("TAG", "失败=========" + t.localizedMessage)
			}
		})
		
		
	}
	
	override fun onStart() {
		super.onStart()
		disposable.add(weatherViewModel.getWeather("101190201")
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					Log.d("TAG", "city_id：" + it.cityid + " city_name：" + it.city + " city_temp：" + it.temp)
					
					this.kt_title.text = "城市ID：" + it.cityid + "  城市：" + it.city + "  温度：" + it.temp
					
					//insertWeather(it)
					
				},
				{ error -> Log.e("TAG", "Unable to get city", error) }
			))
	}
	
	override fun onStop() {
		super.onStop()
		disposable.clear()
	}
	
	private fun insertWeather(weather: Weatherinfoo) {
		disposable.add(
			weatherViewModel.updateWeather(weather)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
					{
						Log.e("TAG", "Update room success")
					},
					{ error ->
						Log.e("TAG", "Unable to update username", error)
					}
				)
		)
	}
	
}
