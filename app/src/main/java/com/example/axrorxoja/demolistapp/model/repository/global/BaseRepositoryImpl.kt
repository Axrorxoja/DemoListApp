package com.example.axrorxoja.demolistapp.model.repository.global

import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.extension.await
import com.example.axrorxoja.demolistapp.widget.SingleLiveEvent
import kotlinx.coroutines.Job

import retrofit2.Call
import timber.log.Timber

/*
* Created by axrorxoja on 10/2/18
*/
abstract class BaseRepositoryImpl<T> :
    IBaseRepository {

    abstract var job: Job?
    abstract val liveData: SingleLiveEvent<BaseData<T>>

    protected suspend fun parseData(call: Call<BaseData<T>>): BaseData<T> {
        return try {
            val res = call.await()
            Timber.d("$res")
            return res
        } catch (e: Exception) {
            e.printStackTrace()
            BaseData()
        }
    }

    override fun cancelAll() {
        job?.cancel()
        liveData.call()
    }
}