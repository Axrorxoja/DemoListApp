package com.example.axrorxoja.demolistapp.di.module.activity

import android.support.v4.app.Fragment
import com.example.axrorxoja.demolistapp.di.subComponent.MainSubComponent
import com.example.axrorxoja.demolistapp.ui.fragments.ListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/*
* Created by axrorxoja on 30/10/18
*/

@Module(
    subcomponents = [
        MainSubComponent::class
    ]
)
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ListFragment::class)
    abstract fun bindList(builder: MainSubComponent.Builder): AndroidInjector.Factory<out Fragment>

}
