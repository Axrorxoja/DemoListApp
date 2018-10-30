package com.example.axrorxoja.demolistapp.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.example.axrorxoja.demolistapp.R
import dagger.android.support.DaggerAppCompatActivity

class AppActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}
