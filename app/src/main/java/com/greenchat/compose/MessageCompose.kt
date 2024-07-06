package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.data.MessageData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen(messageData: MessageData) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar() },
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
                                            ) {
                                                Image(
                                                    painter = painterResource(id = messageData.imageRes),
                                                    contentDescription = null,
                                                    contentScale = ContentScale.Crop,
                                                    modifier = Modifier
                                                        .size(70.dp)
                                                        .padding(8.dp)
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
                                                            text = messageData.messageSender,
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
                                                        Text(
                                                            text = messageData.messageReceiver,
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
                                                            text = "Date: ",
                                                            style = MaterialTheme.typography.bodySmall.copy(
                                                                fontWeight = FontWeight.Normal,
                                                                fontSize = 14.sp
                                                            )
                                                        )
                                                        Text(
                                                            text = messageData.messageTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                                            style = MaterialTheme.typography.bodySmall.copy(
                                                                fontWeight = FontWeight.Bold,
                                                                fontSize = 14.sp,
                                                                color = colorPrimary
                                                            )
                                                        )
                                                    }
                                                }
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                            ) {
                                                Text(
                                                    text = "Subject: ",
                                                    style = MaterialTheme.typography.bodyMedium.copy(
                                                        fontWeight = FontWeight.Normal,
                                                        fontSize = 16.sp
                                                    ),
                                                )
                                                Text(
                                                    text = messageData.messageName,
                                                    style = MaterialTheme.typography.bodyMedium.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 18.sp,
                                                        color = colorPrimary
                                                    ),
                                                )
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
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageScreen() {
    MessageScreen(MessageData.receiveMessage)
}