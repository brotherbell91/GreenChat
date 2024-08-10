package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.R
import com.greenchat.data.EmployeeData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.util.Constants
import java.time.format.DateTimeFormatter
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import java.util.ArrayList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageEditScreen(employeeData: EmployeeData, myData : EmployeeData) {
    val text = remember { mutableStateOf("") }
    val subject = remember { mutableStateOf("") }
    val employeeDataList = ArrayList<EmployeeData>()
    if(employeeData.id != "") employeeDataList.add(employeeData)
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true, Constants.MESSAGE_EDIT_FRAGMENT_TAG, "Send Message") },
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
                        )  {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(4.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(Color.White),
                            ) {
                                LazyRow {
                                    item{
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.Start,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = myData.imageRes),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(50.dp)
                                                        .clip(CircleShape)
                                                        .background(Color.Transparent),
                                                    contentScale = ContentScale.Crop,
                                                )
                                                Column(
                                                    Modifier.fillMaxWidth(),
                                                    verticalArrangement = Arrangement.Top,
                                                ) {
                                                    Row {
                                                        Text(
                                                            text = "From: ",
                                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                                fontWeight = FontWeight.Normal,
                                                                fontSize = 16.sp,
                                                            )
                                                        )
                                                        Text(
                                                            text = myData.name,
                                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                                fontWeight = FontWeight.Bold,
                                                                fontSize = 16.sp,
                                                                color = colorPrimary
                                                            )
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.height(4.dp))
                                                    Row {
                                                        Text(
                                                            text = "To: ",
                                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                                fontWeight = FontWeight.Normal,
                                                                fontSize = 16.sp
                                                            )
                                                        )
                                                        var toText = ""
                                                        for ((index, tempEmployeeData) in employeeDataList.withIndex()) {
                                                            if (index == employeeDataList.size - 1) {
                                                                toText = toText + tempEmployeeData.name
                                                            } else{
                                                                toText = toText + tempEmployeeData.name + ", "
                                                            }
                                                        }
                                                        Text(
                                                            text = toText,
                                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                                fontWeight = FontWeight.Bold,
                                                                fontSize = 16.sp,
                                                                color = colorPrimary
                                                            )
                                                        )
                                                    }
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                horizontalArrangement = Arrangement.Start,
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .height(20.dp)
                                            ) {
                                                Text(
                                                    text = "Subject: ",
                                                    style = MaterialTheme.typography.bodyMedium.copy(
                                                        fontWeight = FontWeight.Normal,
                                                        fontSize = 16.sp
                                                    ),
                                                )
                                                Box(
                                                    modifier = Modifier
                                                        .wrapContentSize()
                                                ) {
                                                    BasicTextField(
                                                        value = subject.value,
                                                        onValueChange = { subject.value = it },
                                                        modifier = Modifier
                                                            .wrapContentSize()
                                                            .background(Color.White),
                                                        textStyle = TextStyle(color = colorPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp),
                                                        cursorBrush = SolidColor(colorPrimary)
                                                    )
                                                    if (subject.value == "") {
                                                        Text(
                                                            text = "Empty subject",
                                                            style = TextStyle(color = Color.Gray, fontSize = 16.sp),
                                                            modifier = Modifier
                                                                .align(Alignment.TopStart)
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
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
                                        TextField(
                                            value = text.value,
                                            onValueChange = { text.value = it },
                                            label = { Text("Enter your message", color = Color.Gray) },
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color.White),
                                            colors = TextFieldDefaults.textFieldColors(
                                                containerColor = Color.White,
                                                cursorColor = colorPrimary,
                                                focusedIndicatorColor = Color.Transparent,
                                                unfocusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                        )
                                    }
                                }
                                FloatingButton(openDashboard = {

                                },
                                    image = R.drawable.chat_send)
                            }
                        }
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageEditCompose() {
    MessageEditScreen(EmployeeData.employeeData, EmployeeData.myData)
}