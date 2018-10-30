package com.example.axrorxoja.demolistapp.di.subComponent

import com.example.axrorxoja.demolistapp.di.module.fragment.MainFragmentModule
import com.example.axrorxoja.demolistapp.di.scope.MainFragmentScope
import com.example.axrorxoja.demolistapp.ui.fragments.ListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 30/10/18
*/
@MainFragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainSubComponent : AndroidInjector<ListFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ListFragment>()
}
