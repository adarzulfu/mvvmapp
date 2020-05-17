package com.adar.mvvm.base

import com.adar.mvvm.base.di.component.AppComponent
import com.adar.mvvm.base.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Zülfü Adar on 17/05/2020
 */
class MyAppClass : DaggerApplication() {

    private val appComponent: AppComponent by lazy { DaggerAppComponent.builder().create(this).build() }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}