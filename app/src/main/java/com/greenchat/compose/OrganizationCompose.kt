package com.greenchat.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greenchat.R
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.ui.ghost_white
import com.greenchat.viewmodel.MyViewModel

@Composable
fun OrganizationScreen(onEmployeeSelected: (EmployeeData) -> Unit, viewModel: MyViewModel) {
    val selectedIndex = remember { mutableStateOf(0) }
    val departmentData by viewModel.departmentData.collectAsState()
    val buddyData by viewModel.buddyData.collectAsState()

    Row(modifier = Modifier.fillMaxSize()) {
        NavigationRail(
            modifier = Modifier
                .width(60.dp)
                .fillMaxHeight(),
            containerColor = ghost_white,
            contentColor = ghost_white
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavigationRailItem(
                    modifier = Modifier.padding(top = 0.dp, bottom = 0.dp),
                    selected = selectedIndex.value == 0,
                    onClick = { selectedIndex.value = 0 },
                    icon = {
                        TabIcons(
                            ImageBitmap.imageResource(id = R.drawable.buddy),
                            selectedIndex.value == 0
                        )
                    },
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = ghost_white,
                        unselectedTextColor = ghost_white,
                        indicatorColor = ghost_white,
                    ),
//                label = { Text("Buddy") }
                )
                NavigationRailItem(
                    modifier = Modifier.padding(top = 0.dp, bottom = 0.dp),
                    selected = selectedIndex.value == 1,
                    onClick = { selectedIndex.value = 1 },
                    icon = {
                        TabIcons(
                            ImageBitmap.imageResource(id = R.drawable.department),
                            selectedIndex.value == 1
                        )
                    },
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = ghost_white,
                        unselectedTextColor = ghost_white,
                        indicatorColor = ghost_white,
                    ),
                )
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()) {
            when (selectedIndex.value) {
                0 -> BuddyScreen(onEmployeeSelected, department = buddyData!!)
                1 -> DepartmentScreen(onEmployeeSelected, department = departmentData!!)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrganizationScreen() {
    OrganizationScreen(onEmployeeSelected = {}, viewModel = viewModel())
}