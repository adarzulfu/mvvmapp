package com.adar.mvvm.base.di.module

import com.adar.mvvm.base.network.Dependecy
import com.adar.mvvm.screen.employee.EmployeeService
import dagger.Module
import dagger.Provides

/**
 * Created by Zülfü Adar on 17/05/2020
 */

@Module
class NetworkModule {

    @Provides
    fun provideNetworkService(): EmployeeService = Dependecy.repository.create(EmployeeService::class.java)
}