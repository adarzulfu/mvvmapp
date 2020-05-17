package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeInformation
import com.adar.mvvm.base.usacase.UseCase
import javax.inject.Inject

/**
 * Created by Zülfü Adar on 01/05/2020
 */
class FetchEmployeeUsaCase @Inject constructor(
    private val repository: EmployeeRepository
) : UseCase<List<EmployeeInformation>, UseCase.None>() {

    override suspend fun buildUseCase(params: UseCase.None): List<EmployeeInformation> {
        return repository.fetchEmployee()
    }
}