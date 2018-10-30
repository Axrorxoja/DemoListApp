package com.example.axrorxoja.demolistapp.presentation.global

import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.entity.global.BaseData
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BasePresenter<T>(private val view: IViewBase<T>) {

    private fun findAppropriateError(error: Exception?): Int {
        return if (error != null) {
            when (error) {
                is UnknownHostException -> R.string.network_not_available
                is ConnectException -> R.string.service_not_available
                is SocketTimeoutException -> R.string.service_not_available
                else -> R.string.un_known_error
            }
        } else {
            R.string.un_known_error
        }
    }

    open fun onSuccess(data: T) {
        view.onShowProgress(false)
        view.onSuccess(data)
    }

    protected fun checkData(data: BaseData<T>?) {
        if (data != null) {
            if (data.success != null) {
                onSuccess(data.success)
            } else {
                val resId = findAppropriateError(data.error)
                view.onFail(resId)
            }
        }
    }
}