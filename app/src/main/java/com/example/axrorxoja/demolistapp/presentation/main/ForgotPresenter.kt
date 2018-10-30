package com.example.axrorxoja.demolistapp.presentation.main

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.entity.main.MainRequest
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.main.IForgotRepository
import com.example.axrorxoja.demolistapp.model.storage.IPreference
import com.example.axrorxoja.demolistapp.presentation.global.BasePresenter
import com.example.axrorxoja.demolistapp.widget.connectionManager.IConnectionManager

class ForgotPresenter(
    private val repo: IForgotRepository,
    private val pref: IPreference,
    private val view: IViewForgot,
    private val connection: IConnectionManager
) : BasePresenter<MainResponse>(view), IPresenterForgot {

    override fun forgot(firstName: String, lastName: String, login: String) {
        if (firstName.isNotEmpty() &&
            lastName.isNotEmpty() &&
            login.isNotEmpty()
        ) {
            if (connection.isHaveNetwork()) {
                view.onShowProgress(true)
                val req = MainRequest(firstName, lastName, login)
                repo.forgot(req).observe(view.lifeCycle(),
                    Observer { checkData(it) })
            } else {
                view.onFail(R.string.network_not_available)
            }
        } else {
            view.onFail(R.string.fields_is_empty)
        }
    }

    override fun onSuccess(data: MainResponse) {
        super.onSuccess(data)
//        pref.code = data.authCode
    }
}