package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.R
import com.greenchat.data.ChatRoomListData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray

@Composable
fun ChatListScreen(openDashboard: (ChatRoomListData, Int) -> Unit) {
    val tabs = listOf("Chat", "OpenChat")
    var selectedTab = remember { mutableStateOf(0) }

    val chatRooms = if (selectedTab.value == 0) {
        ChatRoomListData.chatRooms
    } else {
        ChatRoomListData.openChatRooms
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TabRow(
            containerColor = ghost_white,
            contentColor = ghost_white,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab.value])
                        .padding(start = 70.dp, end = 70.dp),
                    color = colorPrimary,
                )
            },
            selectedTabIndex = selectedTab.value,
            modifier = Modifier.fillMaxWidth(),
            divider = {},
        ) {
            tabs.forEachIndexed { index, title ->

                val tabAnnotatedString = buildAnnotatedString{
                    append(title)
                    addStyle(
                        style = SpanStyle(
                            color = if (selectedTab.value == index) colorPrimary else image_gray,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                        ),
                        start = 0,
                        end = title.length,
                    )
                }

                Tab(
                    selected = selectedTab.value == index,
                    onClick = { selectedTab.value = index },
                    text = {
                        Text(
                            text = tabAnnotatedString,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        ChatRoomList(openDashboard, chatRooms, selectedTab.value)
    }
}

@Composable
fun ChatRoomList(openDashboard: (ChatRoomListData, Int) -> Unit, chatRooms: List<ChatRoomListData>, selectedTab: Int) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(chatRooms) { chatRoom ->
            ChatRoomCard(openDashboard, chatRoom = chatRoom, selectedTab)
        }
    }
}

@Composable
fun ChatRoomCard(openDashboard: (ChatRoomListData, Int) -> Unit, chatRoom: ChatRoomListData, selectedTab: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable {openDashboard(chatRoom, selectedTab)},
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = chatRoom.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = chatRoom.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${chatRoom.participantsCount}",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier.padding(2.dp)
                    )
                }
                Text(
                    text = "${chatRoom.lastChat}",
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End,
            ){
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    if (chatRoom.unreadCount > 0) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.Red, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = chatRoom.unreadCount.toString(),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }
                    } else{
                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom)
                        )
                    }
                }

                Text(
                    text = todayCheck(chatRoom.lastChatTime),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatListScreen() {
    ChatListScreen(openDashboard = { _, _ -> })
}