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
import com.example.todomvvm.data.bean.WeatherNow
import com.example.todomvvm.data.entity.HeWeather6
import com.example.todomvvm.data.entity.Weather
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


//主页
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

        ApiStore.create().now("wuzhong,suzhou").enqueue(object : Callback<WeatherNow> {
            override fun onResponse(call: Call<WeatherNow>, response: Response<WeatherNow>) {
                Log.d("TAG", "成功=获取到的信息=========" + Gson().toJson(response.body()))
                val s = response.body() as WeatherNow
                
                kt_title.text = s.heWeather6[0].basic.location
                cond_txt.text = s.heWeather6[0].now.cond_txt
                
                tmp.text = s.heWeather6[0].now.tmp +"℃"
    
    
//                kt_title.text = "城市ID：" + s.heWeather6[0].basic.cid +
//                    "\n 城市：" + s.heWeather6[0].basic.admin_area + " " + s.heWeather6[0].basic.parent_city + " " + s.heWeather6[0].basic.location +
//                    " 温度：" + s.heWeather6[0].now.tmp
                //insertWeather(response.body()!!)
                
                
            }

            override fun onFailure(call: Call<WeatherNow>, t: Throwable) {
                Log.d("TAG", "失败=========" + t.localizedMessage)
            }
        })
    
        
//        做配色
//        Palette.from(BitmapFactory.decodeResource(resources, R.drawable.beauty))
//            .generate(object : Palette.PaletteAsyncListener() {
//                fun onGenerated(@NonNull palette: Palette) {
//                    val color = palette.getVibrantColor(resources.getColor(R.color.colorAccent))
//                    collapsingToolbarLayout.setContentScrimColor(color)
//                    //因为我暂时没有找到比较好的透明状态栏来适配这一套效果布局。
//                    //因此就直接替换掉StatusBar的颜色，这样其实也蛮好看的。
//                    window!!.statusBarColor = color
//                }
//            })
    
    
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
//        disposable.add(weatherViewModel.getWeather("wuzhong,suzhou")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    Log.d("TAG", "城市ID：" + it.basic.cid + "  城市：" + it.basic.location + "  温度：" + it.t.tmp)
//
//                    this.kt_title.text = "城市ID：" + it.basic.cid + "  城市：" + it.basic.location + "  温度：" + it.t.tmp
//
//                    insertWeather(it)
//
//                },
//                { error -> Log.e("TAG", "Unable to get city", error) }
//            ))
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    private fun insertWeather(heWeather6: HeWeather6) {
        disposable.add(
            weatherViewModel.updateWeather(heWeather6)
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