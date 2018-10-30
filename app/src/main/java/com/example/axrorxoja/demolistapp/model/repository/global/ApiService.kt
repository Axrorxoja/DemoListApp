package com.example.axrorxoja.demolistapp.model.repository.global

import com.example.axrorxoja.demolistapp.entity.global.BaseData
import com.example.axrorxoja.demolistapp.entity.main.MainRequest
import com.example.axrorxoja.demolistapp.entity.main.MainResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/*
* Created by axrorxoja on 30/10/18
*/
interface ApiService {

    @POST("sign_in")
    fun signIn(@Body user: MainRequest): Call<BaseData<MainResponse>>

}