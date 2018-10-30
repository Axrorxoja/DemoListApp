package com.example.axrorxoja.demolistapp.di.module.fragment

import com.example.axrorxoja.demolistapp.di.scope.MainFragmentScope
import com.example.axrorxoja.demolistapp.model.repository.global.ApiService
import com.example.axrorxoja.demolistapp.model.repository.main.ForgotRepositoryImpl
import com.example.axrorxoja.demolistapp.model.repository.main.IForgotRepository
import com.example.axrorxoja.demolistapp.model.storage.IPreference
import com.example.axrorxoja.demolistapp.presentation.main.ForgotPresenter
import com.example.axrorxoja.demolistapp.presentation.main.IPresenterForgot
import com.example.axrorxoja.demolistapp.presentation.main.IViewForgot
import com.example.axrorxoja.demolistapp.ui.fragments.ListFragment
import com.example.axrorxoja.demolistapp.widget.connectionManager.IConnectionManager
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 30/10/18
*/
@Module
class MainFragmentModule {

    @Provides
    @MainFragmentScope
    fun provideRepository(service: ApiService): IForgotRepository = ForgotRepositoryImpl(service)

    @Provides
    @MainFragmentScope
    fun providePresenter(
        repo: IForgotRepository,
        pref: IPreference,
        view: IViewForgot,
        connection: IConnectionManager
    ): IPresenterForgot = ForgotPresenter(repo, pref, view, connection)


    @Provides
    @MainFragmentScope
    fun provideView(fragment: ListFragment): IViewForgot = fragment
}