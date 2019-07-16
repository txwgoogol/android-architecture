package com.example.todomvvm.ui

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.todomvvm.R
import com.example.todomvvm.base.BaseFragment
import com.example.todomvvm.data.entity.Now
import com.example.todomvvm.data.entity.NowX
import com.example.todomvvm.data.source.local.ViewModelFactory
import com.example.todomvvm.data.source.local.WeatherViewModel
import com.example.todomvvm.data.source.remote.ApiStore
import com.example.todomvvm.utils.Injection
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.listenzz.navigation.AwesomeToolbar
import me.listenzz.navigation.BarStyle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 主页
 *
 * @author colin tam
 */
class Home : BaseFragment() {
	
	private lateinit var ctx: Activity
	
	private lateinit var weatherViewModel: WeatherViewModel
	private lateinit var viewModelFactory: ViewModelFactory
	private val disposable = CompositeDisposable()
	
	
	override fun onCreateAwesomeToolbar(parent: View?): AwesomeToolbar? {
		return null
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		ctx = this.requireActivity()
		return inflater.inflate(R.layout.activity_main, container, false)
	}
	
	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		appendStatusBarPadding(kt_toolbar, toolbarHeight)

		viewModelFactory = Injection.provideViewModelFactory(ctx)
		weatherViewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel::class.java)
		
		
		ApiStore.create().now("吴中,苏州").enqueue(object : Callback<Now> {
			override fun onResponse(call: Call<Now>, response: Response<Now>) {
				Log.d("TAG", "成功=获取到的信息=========" + Gson().toJson(response.body()))
				//val s = response.body() as Weather
				//weather_info.text = "城市ID：" + s.weatherInfo.cityid + "\n" + "城市：" + s.weatherInfo.city + "\n" + "时间：" + s.weatherInfo.time + "\n" + "温度：" + s.weatherInfo.temp + "\n"
				insertWeather(response.body()!!)
			}
			
			override fun onFailure(call: Call<Now>, t: Throwable) {
				Log.d("TAG", "失败=========" + t.localizedMessage)
			}
		})
		
	}
	
	override fun preferredStatusBarColor(): Int {
		return Color.TRANSPARENT
	}
	
	override fun preferredStatusBarStyle(): BarStyle {
		return BarStyle.LightContent
	}
	
	override fun preferredStatusBarHidden(): Boolean {
		return false
	}
	
	override fun onStart() {
		super.onStart()
		disposable.add(weatherViewModel.getWeather("101190201")
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					//Log.d("TAG", "city_id：" + it.cityid + " city_name：" + it.city + " city_temp：" + it.temp)
					
					//this.kt_title.text = "城市ID：" + it.cityid + "  城市：" + it.city + "  温度：" + it.temp
					
					//insertWeather(it)
					
				},
				{ error -> Log.e("TAG", "Unable to get city", error) }
			))
	}
	
	override fun onStop() {
		super.onStop()
		disposable.clear()
	}
	
	private fun insertWeather(now: Now) {
		disposable.add(
			weatherViewModel.updateWeather(now)
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