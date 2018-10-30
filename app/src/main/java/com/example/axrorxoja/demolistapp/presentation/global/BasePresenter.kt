package com.example.axrorxoja.demolistapp.presentation.global

import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.common.ErrorCodes
import com.example.axrorxoja.demolistapp.common.ErrorObject
import com.example.axrorxoja.demolistapp.entity.global.BaseData

abstract class BasePresenter<T>(private val view: IViewBase) {

    private fun findAppropriateError(error: ErrorObject?): Int {
        return if (error != null) {
            when (error.code) {
                ErrorCodes.EMPTY_DATA -> R.string.data_is_empty
                else -> R.string.un_known_error
            }
        } else {
            R.string.un_known_error
        }
    }

    open fun onSuccess(data: T) {
        view.onShowProgress(false)
        view.onSuccess()
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