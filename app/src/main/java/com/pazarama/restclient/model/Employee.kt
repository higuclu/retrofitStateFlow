package com.pazarama.restclient.model

data class Employee(
    val id: Int,
    val employee_name: String,
    val employee_salary: Int,
    val employee_age: Int,
    val profile_image: String
)

data class Employees(
    val status: String,
    val data: List<Employee>,
    val message: String
)
