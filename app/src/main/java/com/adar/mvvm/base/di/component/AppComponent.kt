package com.adar.mvvm.base.di.component

import android.app.Application
import com.adar.mvvm.base.MyAppClass
import com.adar.mvvm.base.di.module.ActivityModule
import com.adar.mvvm.base.di.module.NetworkModule
import com.adar.mvvm.base.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Zülfü Adar on 17/05/2020
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<MyAppClass> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}