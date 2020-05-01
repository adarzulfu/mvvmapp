package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeInformation
import com.adar.mvvm.base.usacase.UseCase

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class FetchEmployeeUsaCase(
    private val repository: EmployeeRepository = EmployeeRepository()
) : UseCase<List<EmployeeInformation>, UseCase.None>() {

    override suspend fun buildUseCase(params: UseCase.None): List<EmployeeInformation> {
        return repository.fetchEmployee()
    }
}