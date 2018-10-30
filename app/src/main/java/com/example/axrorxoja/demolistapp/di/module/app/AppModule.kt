package com.example.axrorxoja.demolistapp.di.module.app

import android.content.Context
import android.net.ConnectivityManager
import com.example.axrorxoja.demolistapp.App
import com.example.axrorxoja.demolistapp.di.scope.AppScope
import com.example.axrorxoja.demolistapp.widget.connectionManager.ConnectionManagerImpl
import com.example.axrorxoja.demolistapp.widget.connectionManager.IConnectionManager
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 30/10/18
*/
@Module
class AppModule {
    @AppScope
    @Provides
    fun provideContext(application: App): Context = application.applicationContext

    @AppScope
    @Provides
    fun provideConnectionService(context: Context): IConnectionManager {
        val it = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return ConnectionManagerImpl(it)

    }

}