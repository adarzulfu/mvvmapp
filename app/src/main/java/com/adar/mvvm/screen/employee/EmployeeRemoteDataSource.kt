package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeResponse

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeRemoteDataSource(private val service: EmployeeService) {

    suspend fun fetchEmployeeList(): EmployeeResponse = service.getEmployeeList()
}