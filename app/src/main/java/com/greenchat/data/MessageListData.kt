package com.greenchat.data

import com.greenchat.R
import java.time.LocalDateTime

data class MessageListData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var messageName: String = "",
    var receiverCount: Int = -1,
    var messageTime: LocalDateTime = LocalDateTime.now(),
    var messageSender: String = "",
    var messageReceiver: String = "",
    var unread: Int = -1,
) {
    companion object{
        val receiveMessages = listOf(
            MessageListData(1, R.drawable.profile, "Receive Message 1", 3, LocalDateTime.now(), "이형종", "홍길동", 1),
        )

        val sendMessages = listOf(
            MessageListData(1, R.drawable.profile, "Send Message 1", 10, LocalDateTime.now(), "이형종", "홍길동", 1),
        )
    }
}