package com.adar.mvvm.base.di.module

import com.adar.mvvm.base.KeyStore
import com.adar.mvvm.screen.employee.EmployeeService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Zülfü Adar on 17/05/2020
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi() =Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideOkhttp() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(KeyStore.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { okHttpClient.newCall(it) }
            .build()


    @Singleton
    @Provides
    fun provideNetworkService(retrofit: Retrofit): EmployeeService = retrofit.create(EmployeeService::class.java)
    
}