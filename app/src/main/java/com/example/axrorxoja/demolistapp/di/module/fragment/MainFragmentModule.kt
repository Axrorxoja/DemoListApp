package com.example.axrorxoja.demolistapp.di.module.fragment

import com.example.axrorxoja.demolistapp.di.scope.MainFragmentScope
import com.example.axrorxoja.demolistapp.model.repository.global.ApiService
import com.example.axrorxoja.demolistapp.model.repository.main.IMainRepository
import com.example.axrorxoja.demolistapp.model.repository.main.MainRepositoryImpl
import com.example.axrorxoja.demolistapp.presentation.main.IPresenterMain
import com.example.axrorxoja.demolistapp.presentation.main.IViewMain
import com.example.axrorxoja.demolistapp.presentation.main.MainPresenter
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
    fun provideRepository(service: ApiService): IMainRepository = MainRepositoryImpl(service)

    @Provides
    @MainFragmentScope
    fun providePresenter(
        repo: IMainRepository,
        view: IViewMain,
        connection: IConnectionManager
    ): IPresenterMain = MainPresenter(repo, view, connection)


    @Provides
    @MainFragmentScope
    fun provideView(fragment: ListFragment): IViewMain = fragment
}