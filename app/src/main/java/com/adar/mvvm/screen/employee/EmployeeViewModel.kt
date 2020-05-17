package com.adar.mvvm.screen.employee

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adar.mvvm.base.model.EmployeeInformation
import com.adar.mvvm.base.usacase.UseCase
import com.adar.mvvm.base.viewmodel.BaseAndroidViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeViewModel @Inject constructor(
    application: Application
) : BaseAndroidViewModel(application) {

    @Inject
    lateinit var usaCase: FetchEmployeeUsaCase

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