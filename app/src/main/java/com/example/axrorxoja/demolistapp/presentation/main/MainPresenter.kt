package com.example.axrorxoja.demolistapp.presentation.main

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.main.IMainRepository
import com.example.axrorxoja.demolistapp.presentation.global.BasePresenter
import com.example.axrorxoja.demolistapp.widget.connectionManager.IConnectionManager

class MainPresenter(
    private val repo: IMainRepository,
    private val view: IViewMain<MainResponse>,
    private val connection: IConnectionManager
) : BasePresenter<MainResponse>(view), IPresenterMain {

    override fun loadList() {
        if (connection.isHaveNetwork()) {
            view.onShowProgress(true)
            repo.loadList().observe(
                view.lifeCycle(),
                Observer { checkData(it) }
            )
        } else {
            view.onFail(R.string.network_not_available)
        }
    }
}