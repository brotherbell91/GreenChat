package com.greenchat.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greenchat.data.ChatRoomData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatRoomScreen(chatRoomData : ChatRoomData) {
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

                                Text(text = chatRoomData.name)


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
fun PreviewChatRoomScreen() {
    ChatRoomScreen(ChatRoomData.chat[0])
}