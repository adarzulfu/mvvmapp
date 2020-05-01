package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeInformation
import com.adar.mvvm.base.network.Dependecy.employeeService

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeRepository(
    private val remoteDataSource: EmployeeRemoteDataSource = EmployeeRemoteDataSource(employeeService)
) {
    suspend fun fetchEmployee(): List<EmployeeInformation> {
        return remoteDataSource.fetchEmployeeList().data
    }
}