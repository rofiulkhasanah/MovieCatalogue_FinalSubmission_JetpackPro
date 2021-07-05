package com.dicoding.moviecatalogue.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        Handler(mainLooper).postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 4000
        )
    }
}