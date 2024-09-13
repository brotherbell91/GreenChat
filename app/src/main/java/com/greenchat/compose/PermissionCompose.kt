package com.greenchat.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.greenchat.R
import com.greenchat.data.PermissionData
import com.greenchat.navigation.Screen
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.dark_gray
import com.greenchat.ui.ghost_white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {CustomTopAppBar(false, onClose = {})},
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    color = colorPrimary) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ghost_white),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                                .weight(1f),
                        ) {
                            val loginText = "Allow Required Permissions."
                            val loginWord = "Allow"
                            val loginAnnotatedString = buildAnnotatedString {
                                append(loginText)
                                addStyle(
                                    style = SpanStyle(
                                        color = dark_gray,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                    ),
                                    start = 0,
                                    end = loginText.length
                                )
                                addStyle(
                                    style = SpanStyle(
                                        color = colorPrimary,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                    ),
                                    start = 0,
                                    end = loginWord.length
                                )
                            }

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 20.dp),
                                text = loginAnnotatedString,
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                            )

                            PermissionItems()
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp)
                        ){
                            Button(
                                onClick = {navController.navigate(Screen.Login.route)},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(colorPrimary),
                            ) {
                                Text(
                                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                                    text = "Allow All",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleSmall
                                        .copy(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                )
                            }
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun PermissionItems() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(PermissionData.permissions.count()) { index ->
            PermissionItem(PermissionData.permissions[index])
        }
    }
}

@Composable
fun PermissionItem(permission: PermissionData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = permission.name, style = MaterialTheme.typography.titleSmall)
                    Text(text = permission.description, style = MaterialTheme.typography.bodySmall)
                }
                Image(
                    modifier = Modifier.wrapContentWidth(),
                    painter = painterResource(id = R.drawable.baseline_check_24),
                    colorFilter = ColorFilter.tint(colorPrimary),
                    contentDescription = "header_view_flower_logo"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPermissionScreen() {
    PermissionScreen(navController = rememberNavController())
}