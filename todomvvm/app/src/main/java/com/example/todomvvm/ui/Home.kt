package com.example.todomvvm.ui

import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import androidx.palette.graphics.Palette
import com.blankj.utilcode.util.ScreenUtils
import com.example.todomvvm.R
import com.example.todomvvm.base.BaseFragment
import com.example.todomvvm.data.bean.WeatherNow
import com.example.todomvvm.data.entity.HeWeather6
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
	
	private lateinit var bitmap: Bitmap
	
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
				
				
				val sb = StringBuffer()
				sb.append(s.heWeather6[0].now.tmp)
				sb.append(resources.getString(R.string.tmp))
				tmp.text = sb.toString()


//                kt_title.text = "城市ID：" + s.heWeather6[0].basic.cid +
//                    "\n 城市：" + s.heWeather6[0].basic.admin_area + " " + s.heWeather6[0].basic.parent_city + " " + s.heWeather6[0].basic.location +
//                    " 温度：" + s.heWeather6[0].now.tmp
				//insertWeather(response.body()!!)
				
				
			}
			
			override fun onFailure(call: Call<WeatherNow>, t: Throwable) {
				Log.d("TAG", "失败=========" + t.localizedMessage)
			}
		})
		
		
		val animation = AnimationUtils.loadAnimation(ctx, R.anim.rotate)
		cond_code.animation = animation
		animation.fillAfter = true//保存动画执行后的效果


//
//		Palette.from(BitmapFactory.decodeResource(resources, R.mipmap.cond_code_bg_100))
//			.generate(Palette.PaletteAsyncListener { palette ->
//			if (palette == null) return@PaletteAsyncListener
//			val color = palette.getVibrantColor(ContextCompat.getColor(ctx,android.R.color.transparent))
//			iv_weather_bg.setBackgroundColor(color)
//		})
		
	}
	
	
	//创建线性渐变背景色
	private fun createLinearGradientBitmap(darkColor: Int, color: Int) {
		val bgColors = IntArray(2)
		bgColors[0] = darkColor
		bgColors[1] = color
		
		val bitmap = Bitmap.createBitmap(ScreenUtils.getAppScreenWidth(), ScreenUtils.getAppScreenHeight(), Bitmap.Config.ARGB_8888)
		val canvas = Canvas()
		val paint = Paint()
		
		canvas.setBitmap(bitmap)
		canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
		val gradient = LinearGradient(0f, 0f, 0f, bitmap.height.toFloat(), bgColors[0], bgColors[1], Shader.TileMode.CLAMP)
		paint.shader = gradient
		val rectF = RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat())
		canvas.drawRect(rectF, paint)
		iv_weather_bg.setImageBitmap(bitmap)
	}
	
	override fun onResume() {
		super.onResume()
		
		Palette.from(BitmapFactory.decodeResource(resources, R.mipmap.cond_code_bg_100)).generate(
			Palette.PaletteAsyncListener { palette ->
				if (palette == null) return@PaletteAsyncListener
				if (palette.getDarkVibrantColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
					createLinearGradientBitmap(palette.getDarkVibrantColor(Color.TRANSPARENT), palette.getVibrantColor(Color.TRANSPARENT))
				} else if (palette.getDarkMutedColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
					createLinearGradientBitmap(palette.getDarkMutedColor(Color.TRANSPARENT), palette.getMutedColor(Color.TRANSPARENT))
				} else {
					createLinearGradientBitmap(palette.getLightMutedColor(Color.TRANSPARENT), palette.getLightVibrantColor(Color.TRANSPARENT))
				}
			})
		
		cond_code_bg.setImageBitmap(getImageToChange(BitmapFactory.decodeResource(resources, R.mipmap.cond_code_bg_100)))
		
	}
	
	
	//修改透明度
	//https://www.jianshu.com/p/d0c5402f1d2b
	private fun getImageToChange(mBitmap: Bitmap): Bitmap {
		
		val createBitmap = Bitmap.createBitmap(mBitmap.width, mBitmap.height, Bitmap.Config.ARGB_8888) as Bitmap
		val mWidth = mBitmap.width
		val mHeight = mBitmap.height
		
		for (i in 0 until mHeight) {
			for (j in 0 until mWidth) {
				var color = mBitmap.getPixel(j, i)
				
				var a = Color.alpha(color)
				val r = Color.red(color)
				val g = Color.green(color)
				val b = Color.blue(color)
				
				val index = i * 1.0f / mHeight
				if (index > 0.5f) {
					val temp = i - mHeight / 2.0f
					a = 230 - (temp / 220 * 255).toInt()
				}
				color = Color.argb(a, r, g, b)
				createBitmap.setPixel(j, i, color)
			}
		}
		
		return createBitmap
	}
	
	
	/**
	 * 通过位移运算来做透渐变，相比之前的方法提高90倍左右
	 * @param bitmap
	 * @return
	 */
	private fun handleBitmap(bitmap: Bitmap): Bitmap {
		//透明渐变
		val argb = IntArray(bitmap.width * bitmap.height)
		bitmap.getPixels(argb, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
		
		//循环开始的下标，设置从什么时候开始改变
		val start = argb.size / 2
		
		val width = bitmap.width
		
		for (i in 0 until bitmap.height / 2) {
			for (j in 0 until width) {
				val index = start - width + i * width + j
				if (argb[index] != 0) {
					argb[index] = ((1 - i) / (bitmap.height / 2f)).toInt() * 255.shl(24) or argb[index] and 0x00FFFFFF
				}
			}
		}
		return Bitmap.createBitmap(argb, bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888);
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