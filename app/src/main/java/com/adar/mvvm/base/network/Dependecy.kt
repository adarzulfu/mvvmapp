package com.adar.mvvm.base.network

import com.adar.mvvm.base.network.KeyStore.BASE_URL
import com.adar.mvvm.screen.employee.EmployeeService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Zülfü Adar on 01/05/2020
 */
object Dependecy {

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
    }

    private val okHttpClient: OkHttpClient by lazy { OkHttpClient.Builder().build() }

    private val repository: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { okHttpClient.newCall(it) }
            .build()
    }

    val employeeService: EmployeeService by lazy {
        repository.create(EmployeeService::class.java)
    }
}