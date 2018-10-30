package com.example.axrorxoja.demolistapp.model.repository.main

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import com.example.axrorxoja.demolistapp.model.repository.global.IBaseRepository

/*
* Created by axrorxoja on 30/10/18
*/
interface IMainRepository : IBaseRepository {

    fun loadList(): LiveData<BaseData<MainResponse>>
}