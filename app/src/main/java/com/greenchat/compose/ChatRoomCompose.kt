package com.greenchat.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greenchat.R
import com.greenchat.data.ChatData
import com.greenchat.data.ChatRoomData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray
import com.greenchat.ui.text_hint_color
import com.greenchat.viewmodel.MyViewModel
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatRoomScreen(viewModel: MyViewModel, onEmployeeSelected: () -> Unit, selectedChatRoomData : ChatRoomData, type: Int, onClose: () -> Unit) {
    val chatRoomData by viewModel.chatRoomData.collectAsState()
    val openChatRoomData by viewModel.openChatRoomData.collectAsState()
    val selectedChatRoomId = remember { mutableStateOf(selectedChatRoomData.id) }
    val selectedOpenChatRoomId = remember { mutableStateOf(selectedChatRoomData.id) }
    val chatRoomDataOne = chatRoomData.find { it.id == selectedChatRoomId.value } ?: selectedChatRoomData
    val openChatRoomDataOne = openChatRoomData.find { it.id == selectedOpenChatRoomId.value } ?: selectedChatRoomData

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(true, onClose, selectedChatRoomData.name) },
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
                            val chats = if (type == 0) chatRoomDataOne.chats else openChatRoomDataOne.chats
                            items(chats.sortedBy { it.time }) { chatData ->
                                ChatMessageBubble(chatData = chatData)
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        ChatRoomCustomStyleTextField(
                            placeHolder = "Type a message...",
                            leadingIconId = R.drawable.plus,
                            sendIconId = R.drawable.chat_send,
                            keyboardType = KeyboardType.Text,
                            visualTransformation = VisualTransformation.None,
                            onIconClick = {
                                // 추가 아이콘 클릭 시 동작 추가
                            },
                            onSendChat = { message ->
                                viewModel.sendChat(message, selectedChatRoomId.value, type, selectedChatRoomData)
                            }
                        )
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
                                text = chatData.time.format(DateTimeFormatter.ofPattern("a h:mm", Locale.ENGLISH)),
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
                                text = chatData.time.format(DateTimeFormatter.ofPattern("a h:mm", Locale.ENGLISH)),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatRoomCustomStyleTextField(
    placeHolder: String,
    leadingIconId: Int,
    sendIconId: Int,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    onIconClick: () -> Unit,
    onSendChat: (String) -> Unit
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            value = textState.value,
            onValueChange = { valueChanged ->
                textState.value = valueChanged
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            placeholder = { Text(text = placeHolder, color = text_hint_color) },
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Image(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(23.dp)
                                .clickable(onClick = onIconClick),
                            bitmap = ImageBitmap.imageResource(id = leadingIconId),
                            colorFilter = ColorFilter.tint(colorPrimary),
                            contentDescription = "custom_text_field"
                        )
                        Canvas(
                            modifier = Modifier.height(24.dp)
                        ) {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = 2.0F
                            )
                        }
                    }
                )
            },
            trailingIcon = {
                Image(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(23.dp)
                        .clickable {
                            onSendChat(textState.value.text)
                            textState.value = TextFieldValue() //채팅 메시지 초기화
                        },
                    bitmap = ImageBitmap.imageResource(id = sendIconId),
                    colorFilter = ColorFilter.tint(
                        if(textState.value.text.isNotEmpty()) colorPrimary else image_gray
                    ),
                    contentDescription = "send_message_icon"
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorPrimary,
                unfocusedBorderColor = Color.Transparent,
                focusedLabelColor = Color.White,
                focusedTrailingIconColor = Color.White,
            ),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            visualTransformation = visualTransformation
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatRoomScreen() {
    ChatRoomScreen(viewModel = viewModel(), onEmployeeSelected = {}, ChatRoomData.chatRoom[0], 0,onClose = {})
}