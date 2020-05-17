package com.adar.mvvm.base.di.module

import com.adar.mvvm.screen.employee.EmployeeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Zülfü Adar on 17/05/2020
 */

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeEmployeeActivity():EmployeeActivity
}