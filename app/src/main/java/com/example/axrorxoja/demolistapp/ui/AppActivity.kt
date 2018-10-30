package com.example.axrorxoja.demolistapp.ui

import android.os.Bundle
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.presentation.IViewActivity
import dagger.android.support.DaggerAppCompatActivity

class AppActivity :
    DaggerAppCompatActivity(),
    IViewActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
