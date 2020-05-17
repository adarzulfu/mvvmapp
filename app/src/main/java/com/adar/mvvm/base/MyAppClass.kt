package com.adar.mvvm.base

import android.app.Application
import com.adar.mvvm.base.di.component.AppComponent
import com.adar.mvvm.base.di.component.DaggerAppComponent

/**
 * Created by Zülfü Adar on 17/05/2020
 */
class MyAppClass:Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}