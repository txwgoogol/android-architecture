package com.example.todomvvm.ui

import android.graphics.Color
import android.os.Bundle
import me.listenzz.navigation.AppUtils
import me.listenzz.navigation.AwesomeActivity
import me.listenzz.navigation.Style

class MainActivity : AwesomeActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		AppUtils.setStatusBarTranslucent(window, true)
		if (savedInstanceState == null) {
			setActivityRootFragment(Home())
		}
	}
	
	override fun onCustomStyle(style: Style) {
		super.onCustomStyle(style)
		style.screenBackgroundColor = Color.parseColor("#F8F8F8")
		style.isSwipeBackEnabled = true // 开启手势返回
	}
	
}