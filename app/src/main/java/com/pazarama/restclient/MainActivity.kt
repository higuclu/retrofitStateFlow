package com.pazarama.restclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pazarama.restclient.model.Employee
import com.pazarama.restclient.ui.theme.RestClientTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: HumanResourcesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HumanResourcesViewModel(ServiceRepository())
        setContent {
            RestClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EmployeeList(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun EmployeeList(viewModel: HumanResourcesViewModel) {
    val employees by viewModel.employees.collectAsState(initial = emptyList())
    if (employees.isNotEmpty()) {
        LazyColumn(modifier = Modifier.padding(8.dp, 0.dp)) {
            items(employees) { employee ->
                EmployeeItem(employee = employee)
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    } else {
        Box(modifier =Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text(
                text = "No Employee Found",
                modifier = Modifier
            )

        }
    }
}

@Composable
fun EmployeeItem(employee: Employee) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = "Name : ${employee.employee_name}")
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        )
        Text(text = "Age : ${employee.employee_age}")
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        )
        Text(text = "Salary : ${employee.employee_salary} TL")

    }
}