package com.greenchat.data

import java.time.LocalDateTime

data class ChatData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var unreadCount: Int = -1,
    var time: LocalDateTime = LocalDateTime.now(),
    var content: String = "",
)