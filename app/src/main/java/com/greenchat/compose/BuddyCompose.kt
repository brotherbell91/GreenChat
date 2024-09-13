package com.greenchat.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData

@Composable
fun BuddyScreen(onEmployeeSelected: (EmployeeData) -> Unit, department: DepartmentData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            DepartmentHierarchy(onEmployeeSelected, department)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBuddyScreen() {
    BuddyScreen(onEmployeeSelected = {}, DepartmentData.organizationBuddy)
}