package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greenchat.R
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(employeeData : EmployeeData, onClose: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true, onClose, employeeData.name) },
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
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Image(
                                    painter = painterResource(id = employeeData.imageRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(90.dp)
                                        .clip(CircleShape)
                                        .background(Color.White),
                                    contentScale = ContentScale.Crop,
                                )
                            }

                            Spacer(modifier = Modifier.height(25.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clickable { }
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.chat),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Chat"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clickable { }
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.message),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Message"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(45.dp)
                                        .clickable { }
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.phone),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Employee"
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))


                            Column(
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                LazyColumn(
                                    verticalArrangement = Arrangement.Top,
                                    modifier = Modifier
                                        .padding(16.dp),
                                ) {
                                    item{
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(bottom = 30.dp),
                                            verticalArrangement = Arrangement.Top,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {
                                            ProfileItem(itemTitle = "Name", itemValue = employeeData.name)
                                            ProfileItem(itemTitle = "Department", itemValue = employeeData.department)
                                            ProfileItem(itemTitle = "Position", itemValue = employeeData.position)
                                            ProfileItem(itemTitle = "Email", itemValue = employeeData.id)
                                            ProfileItem(itemTitle = "Phone number", itemValue = employeeData.phone)
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun ProfileHeaderView() {
    Image(
        modifier = Modifier.fillMaxSize(),
        bitmap = ImageBitmap.imageResource(id = R.drawable.login_bg),
        contentScale = ContentScale.FillWidth,
        contentDescription = "header_view_login_bg"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 40.dp)
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip((CircleShape)),
            bitmap = ImageBitmap.imageResource(id = R.drawable.profile),
            contentScale = ContentScale.Crop,
            contentDescription = "header_view_profile"
        )
    }
}

@Composable
fun ProfileItem(itemTitle: String, itemValue: String) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 5.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 25.dp)
        ) {
            Text(
                text = itemTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = colorPrimary
            )
            Text(
                text = itemValue,
                style = MaterialTheme.typography.labelLarge,
                color = colorPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(DepartmentData.organizationDepartment.employees.get(0), onClose = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileItem() {
    ProfileItem("Name", "이형종")
}