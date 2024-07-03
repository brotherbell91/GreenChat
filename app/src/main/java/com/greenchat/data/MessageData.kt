package com.greenchat.data

import com.greenchat.R
import java.time.LocalDateTime

data class MessageData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var messageName: String = "",
    var receiverCount: Int = -1,
    var messageTime: LocalDateTime = LocalDateTime.now(),
    var messageSender: String = "",
    var messageReceiver: String = "",
) {
    companion object{
        val receiveMessage = MessageData(1, R.drawable.profile, "Receive Message 1", 3, LocalDateTime.now(), "홍길동", "이형종, 김동범, 오수빈")
        val sendMessage = MessageData(1, R.drawable.profile, "Send Message 1", 3, LocalDateTime.now(), "이형종", "홍길동, 김동범, 오수빈")
    }
}