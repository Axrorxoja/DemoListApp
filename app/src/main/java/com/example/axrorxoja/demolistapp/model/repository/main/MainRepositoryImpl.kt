package com.example.axrorxoja.demolistapp.model.repository.main

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.global.ApiService
import com.example.axrorxoja.demolistapp.model.repository.global.BaseRepositoryImpl
import com.example.axrorxoja.demolistapp.widget.SingleLiveEvent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<MainResponse>(),
    IMainRepository {

    override var job: Job? = null
    override val liveData by lazy { SingleLiveEvent<BaseData<MainResponse>>() }

    override fun loadList(): LiveData<BaseData<MainResponse>> {
        cancelAll()
        job = GlobalScope.launch {
            val data = parseData(service.loadList())
            liveData.postValue(data)
        }
        return liveData
    }
}