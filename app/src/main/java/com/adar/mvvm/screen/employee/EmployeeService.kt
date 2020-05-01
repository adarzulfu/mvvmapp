package com.adar.mvvm.screen.employee

import com.adar.mvvm.base.model.EmployeeResponse
import retrofit2.http.GET

/**
 * Created by Zülfü Adar on 01/05/2020
 */
interface EmployeeService {

    @GET("employees")
    suspend fun getEmployeeList(): EmployeeResponse
}