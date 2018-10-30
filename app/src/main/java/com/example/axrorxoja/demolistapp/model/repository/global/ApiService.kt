package com.example.axrorxoja.demolistapp.model.repository.global

import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import retrofit2.Call
import retrofit2.http.GET


/*
* Created by axrorxoja on 30/10/18
*/
interface ApiService {

    @GET("search/ByLiked")
    fun loadList(): Call<BaseData<MainResponse>>

}