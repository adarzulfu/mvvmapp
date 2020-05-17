package com.adar.mvvm.base.di.component

import android.app.Application
import com.adar.mvvm.base.di.module.NetworkModule
import com.adar.mvvm.base.di.module.ViewModelModule
import com.adar.mvvm.screen.employee.EmployeeActivity
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Zülfü Adar on 17/05/2020
 */
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
    fun inject(activity: EmployeeActivity)
}