package com.pazarama.restclient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pazarama.restclient.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HumanResourcesViewModel(private val repository: ServiceRepository) : ViewModel() {
    private val _employees = MutableStateFlow<List<Employee>>(emptyList())
    val employees : StateFlow<List<Employee>> get() = _employees

    init {
        getAllEmployees()
    }

    fun getAllEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getAllEmployees()
            _employees.value = result
        }
    }
}