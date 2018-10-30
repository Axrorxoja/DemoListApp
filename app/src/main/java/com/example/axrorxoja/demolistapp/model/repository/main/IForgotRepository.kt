package com.example.axrorxoja.demolistapp.model.repository.main

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainRequest
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 30/10/18
*/
interface IForgotRepository : IBaseRepository {

    fun forgot(request: MainRequest): LiveData<BaseData<MainResponse>>
}