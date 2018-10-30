package com.example.axrorxoja.demolistapp.di.module.app

import android.app.Activity
import com.example.axrorxoja.demolistapp.di.subComponent.AppActivitySubComponent
import com.example.axrorxoja.demolistapp.ui.AppActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/*
* Created by axrorxoja on 30/10/18
*/

@Module(
    subcomponents = [
        AppActivitySubComponent::class]
)
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(AppActivity::class)
    abstract fun bindActivity(builder: AppActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}
