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
import androidx.compose.ui.graphics.ColorFilter
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
import com.greenchat.data.MessageData
import com.greenchat.data.MessageListData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray

@Composable
fun MessageListScreen(onMessageSelected: (MessageData) -> Unit) {
    val tabs = listOf("ReceiveMessage", "SendMessage")
    var selectedTab = remember { mutableStateOf(0) }

    val messages = if (selectedTab.value == 0) {
        MessageListData.receiveMessages
    } else {
        MessageListData.sendMessages
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
        MessageList(onMessageSelected, messages, selectedTab.value)
    }
}

@Composable
fun MessageList(onMessageSelected: (MessageData) -> Unit, messages: List<MessageListData>, selectedTab : Int) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(messages) { message ->
            MessageCard(onMessageSelected, message, selectedTab)
        }
    }
}

@Composable
fun MessageCard(onMessageSelected: (MessageData) -> Unit, message: MessageListData, selectedTab : Int) {
    val messages = if (selectedTab == 0) MessageData.receiveMessage else MessageData.sendMessage
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable {onMessageSelected(findMessageDataById(messages, message.id)!!)},
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
                painter = painterResource(id = message.imageRes),
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
                    var text = if (selectedTab == 0){
                        message.sender
                    } else{
                        message.receiver
                    }

                    val textLength = text.length
                    if(textLength > 16){
                        text = text.substring(0, 16) + "..."
                    }
                    Text(
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Text(
                        text = "${message.receiverCount}",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier.padding(2.dp)
                    )
                }
                Text(
                    text = "${message.name}",
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
                    if (message.unread > 0) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.Red, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.message),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(13.dp)
                                    .clip(CircleShape)
                                    .align(Alignment.Center),
                                colorFilter = ColorFilter.tint(Color.White)
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
                    text = todayCheck(message.time),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageListScreen() {
    MessageListScreen(onMessageSelected = {})
}

private fun findMessageDataById(messages: List<MessageData>, id: Int): MessageData? {
    var low = 0
    var high = messages.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val midVal = messages[mid]

        when {
            midVal.id < id -> low = mid + 1
            midVal.id > id -> high = mid - 1
            else -> return midVal
        }
    }
    return null
}