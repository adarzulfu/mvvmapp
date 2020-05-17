package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeResponse
import javax.inject.Inject

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeRemoteDataSource @Inject constructor(private val service: EmployeeService) {

    suspend fun fetchEmployeeList(): EmployeeResponse = service.getEmployeeList()
}