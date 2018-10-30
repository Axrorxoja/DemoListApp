package com.example.axrorxoja.demolistapp.di.subComponent

import com.example.axrorxoja.demolistapp.di.module.activity.AppActivityModule
import com.example.axrorxoja.demolistapp.di.module.activity.FragmentModule
import com.example.axrorxoja.demolistapp.di.scope.AppActivityScope
import com.example.axrorxoja.demolistapp.ui.AppActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 30/10/18
*/
@AppActivityScope
@Subcomponent(
    modules = [
        AppActivityModule::class,
        FragmentModule::class]
)
interface AppActivitySubComponent : AndroidInjector<AppActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AppActivity>()
}
