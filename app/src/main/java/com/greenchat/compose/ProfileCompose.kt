package com.greenchat.compose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.data.MessageListData

@Composable
fun ProfileScreen(employeeData : EmployeeData) {

    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.id)
    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.name)
    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.position)

}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(DepartmentData.organizationDepartment.employees.get(0))
}