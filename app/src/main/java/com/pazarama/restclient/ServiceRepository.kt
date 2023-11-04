package com.pazarama.restclient

import android.util.Log
import com.pazarama.restclient.model.Employee
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceRepository {
    private val proxy: InterfaceHumanResources

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        proxy = retrofit.create(InterfaceHumanResources::class.java)
    }

    suspend fun getAllEmployees(): List<Employee> {
        val response = proxy.getAllEmployees()
        if(response.isSuccessful)
            Log.d("ServiceRepository",response.body()?.data.toString())
        else Log.e("ServiceRepository","response is not successfull")
        return if (response.isSuccessful) {
            response.body()?.data ?: emptyList()
        } else {
            emptyList() // Hata durumunda boş bir liste döndürülüyor
        }
    }
}