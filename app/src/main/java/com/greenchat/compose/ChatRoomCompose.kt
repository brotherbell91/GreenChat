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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greenchat.data.ChatData
import com.greenchat.data.ChatRoomData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatRoomScreen(chatRoomData : ChatRoomData) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true) },
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
                        LazyColumn(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxSize(),
                        ) {
                            items(chatRoomData.chats.sortedBy { it.time }) { chatData ->
                                ChatMessageBubble(chatData = chatData)
                            }
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun ChatMessageBubble(chatData: ChatData) {
    val isCurrentUser = chatData.name == "이형종"
    val alignment = if (isCurrentUser) Alignment.TopEnd else Alignment.TopStart
    val textColor = if (isCurrentUser) Color.White else Color.Black
    val arrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start
    val cardColors = if (isCurrentUser) CardDefaults.cardColors(colorPrimary) else CardDefaults.cardColors(Color.White)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        contentAlignment = alignment
    ) {
        Row(
            horizontalArrangement = arrangement,
            verticalAlignment = Alignment.Top,
        ) {
            if (!isCurrentUser) {
                Image(
                    painter = painterResource(id = chatData.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Transparent),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Column(
                horizontalAlignment = if (isCurrentUser) Alignment.End else Alignment.Start,
            ) {
                if (!isCurrentUser) {
                    Text(
                        text = chatData.name,
                        color = textColor,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom,
                ){
                    if(isCurrentUser){
                        Column(
                            horizontalAlignment = Alignment.End,
                        ) {
                            Text(
                                text = chatData.unreadCount.toString(),
                                color = colorPrimary,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = chatData.time.format(DateTimeFormatter.ofPattern("a h:mm")),
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Card(
                        modifier = Modifier
                            .wrapContentSize(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = cardColors,
                    ) {
                        Text(
                            text = chatData.content,
                            color = textColor,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    if(!isCurrentUser){
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            ) {
                            Text(
                                text = chatData.unreadCount.toString(),
                                color = colorPrimary,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = chatData.time.format(DateTimeFormatter.ofPattern("a h:mm")),
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatRoomScreen() {
    ChatRoomScreen(ChatRoomData.chat[0])
}