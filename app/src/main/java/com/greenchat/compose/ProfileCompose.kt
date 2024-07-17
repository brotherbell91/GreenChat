package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.R
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.util.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(employeeData : EmployeeData) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true, Constants.MESSAGE_FRAGMENT_TAG, employeeData.name) },
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
                            Column(

                            ) {
                                Image(
                                    painter = painterResource(id = employeeData.imageRes),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(70.dp)
                                        .clip(CircleShape)
                                        .background(Color.Transparent),
                                    contentScale = ContentScale.Crop,
                                )
                            }

                            Card(
                                modifier = Modifier
                                    .fillMaxSize(),
                                elevation = CardDefaults.cardElevation(4.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(Color.White),
                            ) {
                                LazyColumn(
                                    verticalArrangement = Arrangement.Top,
                                    modifier = Modifier
                                        .padding(16.dp),
                                ) {
                                    item{
                                        Text(
                                            text = "Hi HyeongJong Lee!!",
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 16.sp
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            },
        )
    }
//    JetPackComposeTheme {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            item {
//                ConstraintLayout {
//                    val (image, profileForm) = createRefs()
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .height(280.dp)
//                            .constrainAs(image) {
//                                top.linkTo(profileForm.top)
//                                bottom.linkTo(profileForm.top)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            }) {
//                        ProfileHeaderView()
//                    }
//                    Card(
//                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = ghost_white
//                        ),
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(top = 100.dp)
//                            .constrainAs(profileForm) {
//                                bottom.linkTo(parent.bottom)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            }
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(30.dp)
//                        ) {
//                            Row(
//                                modifier = Modifier.fillMaxSize(),
//                                horizontalArrangement = Arrangement.SpaceAround,
//                                verticalAlignment = Alignment.CenterVertically,
//                            ){
//                                Image(
//                                    modifier = Modifier
//                                        .size(50.dp)
//                                        .clip((CircleShape)),
//                                    bitmap = ImageBitmap.imageResource(id = R.drawable.chat),
//                                    contentScale = ContentScale.Crop,
//                                    colorFilter = ColorFilter.tint(colorPrimary),
//                                    contentDescription = "Add Chat"
//                                )
//                                Image(
//                                    modifier = Modifier
//                                        .size(50.dp)
//                                        .clip((CircleShape)),
//                                    bitmap = ImageBitmap.imageResource(id = R.drawable.message),
//                                    contentScale = ContentScale.Crop,
//                                    colorFilter = ColorFilter.tint(colorPrimary),
//                                    contentDescription = "Add Message"
//                                )
//                                Image(
//                                    modifier = Modifier
//                                        .size(50.dp)
//                                        .clip((CircleShape)),
//                                    bitmap = ImageBitmap.imageResource(id = R.drawable.department),
//                                    contentScale = ContentScale.Crop,
//                                    colorFilter = ColorFilter.tint(colorPrimary),
//                                    contentDescription = "Add Employee"
//                                )
//                            }
//                            Column(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(bottom = 30.dp),
//                                verticalArrangement = Arrangement.Top,
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                            ) {
//                                Spacer(modifier = Modifier.height(50.dp))
//                                ProfileItem(itemTitle = "Name", itemValue = employeeData.name)
//                                ProfileItem(itemTitle = "Email", itemValue = employeeData.id)
//                                ProfileItem(itemTitle = "Position", itemValue = employeeData.position)
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
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
    ProfileScreen(DepartmentData.organizationDepartment.employees.get(0))
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileItem() {
    ProfileItem("Name", "이형종")
}