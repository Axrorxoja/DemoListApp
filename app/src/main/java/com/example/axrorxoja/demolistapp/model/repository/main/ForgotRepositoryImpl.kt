package com.example.axrorxoja.demolistapp.model.repository.main

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainRequest
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.global.ApiService
import com.example.axrorxoja.demolistapp.model.repository.global.BaseRepositoryImpl
import com.example.axrorxoja.demolistapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ForgotRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<MainResponse>(),
    IForgotRepository {

    override var job: Job? = null
    override val liveData by lazy { SingleLiveEvent<BaseData<MainResponse>>() }

    override fun forgot(request: MainRequest): LiveData<BaseData<MainResponse>> {
        job = GlobalScope.launch {
//            val data = parseData(service.forgot(request))
//            liveData.postValue(data)
        }
        return liveData
    }
}