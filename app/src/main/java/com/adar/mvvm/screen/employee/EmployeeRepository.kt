package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeInformation
import javax.inject.Inject

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class EmployeeRepository @Inject constructor(
    private val remoteDataSource: EmployeeRemoteDataSource
) {
    suspend fun fetchEmployee(): List<EmployeeInformation> {
        return remoteDataSource.fetchEmployeeList().data
    }
}