package com.greenchat.data

import java.time.LocalDateTime

data class ChatRoomData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var participantsCount: Int = -1,
    var participants: List<EmployeeData> = emptyList(),
    var chats: List<ChatData> = emptyList(),
) {
    companion object{

    }
}