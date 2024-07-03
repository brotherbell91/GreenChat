package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.data.MessageData
import java.time.format.DateTimeFormatter

@Composable
fun MessageScreen(messageData : MessageData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = messageData.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "From: ${messageData.messageSender}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "To: ${messageData.messageReceiver}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Time: ${messageData.messageTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Message:", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = messageData.messageName, style = MaterialTheme.typography.bodyMedium, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageScreen() {
    MessageScreen(MessageData.receiveMessage)
}