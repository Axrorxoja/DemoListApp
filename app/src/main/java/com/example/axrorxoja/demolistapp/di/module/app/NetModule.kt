package com.example.axrorxoja.demolistapp.di.module.app

import com.example.axrorxoja.demolistapp.common.API_URL
import com.example.axrorxoja.demolistapp.di.scope.AppScope
import com.example.axrorxoja.demolistapp.model.repository.global.ApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/*
* Created by axrorxoja on 10/2/18
*/
@Module
class NetModule {

    @AppScope
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @AppScope
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(ChuckInterceptor(context))
            .build()
    }

    @AppScope
    @Provides
    fun provideApiService(moshi: Moshi, client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(ApiService::class.java)
    }
}