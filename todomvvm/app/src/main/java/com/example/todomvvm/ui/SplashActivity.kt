package com.example.todomvvm.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.todomvvm.R
import me.listenzz.navigation.AwesomeActivity

//启动页
class SplashActivity : AwesomeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//		setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            overridePendingTransition(R.anim.nav_fade_in, R.anim.nav_fade_out)
            finish()
        }, 1500)

    }

}