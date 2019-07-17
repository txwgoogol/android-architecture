package com.example.todomvvm.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import me.listenzz.navigation.AppUtils
import me.listenzz.navigation.AwesomeActivity
import me.listenzz.navigation.Style

//主活动页 作为整个app的宿主
class MainActivity : AwesomeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isStatusBarTranslucent = true

        if (savedInstanceState == null) {
            setActivityRootFragment(Home())
        }

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.i(AwesomeActivity.TAG, "onAttachedToWindow 是否刘海眉：" + AppUtils.isCutout(this))
    }

    override fun onCustomStyle(style: Style) {
        super.onCustomStyle(style)
        style.screenBackgroundColor = Color.parseColor("#F8F8F8")
        style.isSwipeBackEnabled = true // 开启手势返回
    }

}