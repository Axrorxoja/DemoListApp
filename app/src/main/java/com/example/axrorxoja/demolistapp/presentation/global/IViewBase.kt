package com.example.axrorxoja.demolistapp.presentation.global

import android.arch.lifecycle.LifecycleOwner
import android.support.annotation.StringRes
import android.view.View

interface IViewBase<T> {

    fun lifeCycle(): LifecycleOwner

    fun onSuccess(data: T)

    fun onFail(@StringRes stringRes: Int)

    fun onShowProgress(isShow: Boolean)

}