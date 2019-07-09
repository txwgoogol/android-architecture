package com.example.todomvvm.app

import android.app.Application

/**
 * 自定义Application在应用启动的时候初始化
 *
 * @author COLIN TAM
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //各种初始化
        init()
    }

    //各种初始化
    private fun init() {

    }

    //调用companion object 里面的方法或变量
    init {
        instance = this
    }

    // companion object 修饰为伴生对象,
    // 伴生对象在类中只能存在一个，类似于java中的静态方法
    // Java 中使用类访问静态成员，静态方法。
    companion object {
        lateinit var instance: App
    }

}