package com.greenchat.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.greenchat.R
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.ui.JetPackComposeTheme
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.dark_gray
import com.greenchat.ui.ghost_white
import com.greenchat.ui.gray
import com.greenchat.ui.light_gray

@Composable
fun ProfileScreen(employeeData : EmployeeData) {

    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.id)
    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.name)
    Log.d("TAG", "$$$$ ProfileScreen: " + employeeData.position)

    JetPackComposeTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ConstraintLayout {
                    val (image, loginForm) = createRefs()
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(280.dp)
                            .constrainAs(image) {
                                top.linkTo(loginForm.top)
                                bottom.linkTo(loginForm.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                        ProfileHeaderView()
                    }
                    Card(
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = ghost_white
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 100.dp)
                            .constrainAs(loginForm) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.chat),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Chat"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.message),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Message"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip((CircleShape)),
                                    bitmap = ImageBitmap.imageResource(id = R.drawable.department),
                                    contentScale = ContentScale.Crop,
                                    colorFilter = ColorFilter.tint(colorPrimary),
                                    contentDescription = "Add Employee"
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(bottom = 30.dp),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(text = "Name : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)

                                    Text(text = "Name : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(text = "Email : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)

                                    Text(text = "Name : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(text = "Position : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)

                                    Text(text = "Name : ",
                                        fontSize = 30.sp,
                                        color = colorPrimary)
                                }
                            }
                        }
                    }
                }
            }
        }
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

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(DepartmentData.organizationDepartment.employees.get(0))
}