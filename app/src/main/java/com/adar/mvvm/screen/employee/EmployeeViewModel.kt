package com.adar.mvvm.screen.employee

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adar.mvvm.base.model.EmployeeInformation
import com.adar.mvvm.base.usacase.UseCase
import com.adar.mvvm.base.viewmodel.BaseAndroidViewModel
import kotlinx.coroutines.launch

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeViewModel(
    application: Application
) : BaseAndroidViewModel(application) {
    private val usaCase: FetchEmployeeUsaCase = FetchEmployeeUsaCase()

    val employeeList = MutableLiveData<List<EmployeeInformation>>()

    fun fetchEmployeeViewModel() {
        viewModelScope.launch {
            val response = usaCase.run(UseCase.None)
            response.either(::handleFailure, ::postEmployeeList)
        }
    }

    private fun postEmployeeList(employeeInformation: List<EmployeeInformation>) {
        employeeList.value = employeeInformation
    }
}