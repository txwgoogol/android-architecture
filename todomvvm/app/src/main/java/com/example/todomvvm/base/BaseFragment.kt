package com.example.todomvvm.base

import me.listenzz.navigation.AwesomeFragment

//Fragment  基类
open class BaseFragment : AwesomeFragment() {

    override fun onViewAppear() {
        super.onViewAppear()
        val drawerFragment = drawerFragment
        drawerFragment?.setMenuInteractive(isNavigationRoot)
    }

}