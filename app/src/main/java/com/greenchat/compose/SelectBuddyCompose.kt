package com.greenchat.compose


import com.greenchat.util.Constants
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.viewmodel.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBuddyScreen(viewModel : MyViewModel, onEmployeeSelected: (EmployeeData) -> Unit, onClose: () -> Unit) {
    val departmentData by viewModel.departmentData.collectAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true, onClose, Constants.SELECT_BUDDY_TITLE) },
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    color = colorPrimary
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ghost_white),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxSize(),
                        ) {
                            DepartmentScreen(onEmployeeSelected, department = departmentData!!)
                        }
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectBuddyScreen() {
    SelectBuddyScreen(viewModel = viewModel(), onEmployeeSelected = {}, onClose = {})
}