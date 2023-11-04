package com.pazarama.restclient

import com.pazarama.restclient.model.Employee
import com.pazarama.restclient.model.Employees
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceHumanResources {
        @GET("/api/v1/employees")
        suspend fun getAllEmployees(): Response<Employees>
}