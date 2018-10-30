package com.example.axrorxoja.demolistapp.di.component

import com.example.axrorxoja.demolistapp.App
import com.example.axrorxoja.demolistapp.di.module.app.ActivityModule
import com.example.axrorxoja.demolistapp.di.module.app.AppModule
import com.example.axrorxoja.demolistapp.di.module.app.NetModule
import com.example.axrorxoja.demolistapp.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/*
* Created by axrorxoja on 30/10/18
*/
@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
