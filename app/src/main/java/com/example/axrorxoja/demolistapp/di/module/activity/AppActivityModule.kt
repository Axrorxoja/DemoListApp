package com.example.axrorxoja.demolistapp.di.module.activity

import com.example.axrorxoja.demolistapp.di.scope.AppActivityScope
import com.example.axrorxoja.demolistapp.presentation.IViewActivity
import com.example.axrorxoja.demolistapp.ui.AppActivity
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 30/10/18
*/
@Module
class AppActivityModule {

    @AppActivityScope
    @Provides
    fun providesPresenter(activity: AppActivity): IViewActivity = activity

}