package com.greenchat.data

import com.greenchat.R
import java.time.LocalDateTime

data class ChatRoomData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var roomName: String = "",
    var participantsCount: Int = -1,
    var lastMessageTime: LocalDateTime = LocalDateTime.now(),
    var lastMessage: String = "",
    var unreadCount: Int = -1,
){
    companion object{
        val chatRooms = listOf(
            ChatRoomData(1, R.drawable.profile, "Chat Room 1", 10, LocalDateTime.now(), "Last message 1", 2),
            ChatRoomData(2, R.drawable.profile, "Chat Room 2", 5, LocalDateTime.now(), "Last message 2", 6),
            ChatRoomData(3, R.drawable.profile, "Chat Room 3", 8, LocalDateTime.of(2024, 6,6, 8, 16,32 ), "Last message 3", 5),
            ChatRoomData(4, R.drawable.profile, "Chat Room 4", 8, LocalDateTime.of(2024, 6,7, 8, 16,32 ), "Last message 3", 5),
            ChatRoomData(5, R.drawable.profile, "Chat Room 5", 8, LocalDateTime.of(2023, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomData(6, R.drawable.profile, "Chat Room 6", 8, LocalDateTime.of(2022, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomData(7, R.drawable.profile, "Chat Room 7", 10, LocalDateTime.now(), "Last message 4", 0),
            ChatRoomData(8, R.drawable.profile, "Chat Room 8", 5, LocalDateTime.now(), "Last message 5", 0),
            ChatRoomData(9, R.drawable.profile, "Chat Room 9", 8, LocalDateTime.now(), "Last message 6", 2),
            ChatRoomData(10, R.drawable.profile, "Chat Room 10", 10, LocalDateTime.now(), "Last message 7", 1),
            ChatRoomData(11, R.drawable.profile, "Chat Room 11", 5, LocalDateTime.now(), "Last message 8", 0),
            ChatRoomData(12, R.drawable.profile, "Chat Room 12", 8, LocalDateTime.now(), "Last message 9", 3),
            ChatRoomData(13, R.drawable.profile, "Chat Room 13", 10, LocalDateTime.now(), "Last message 10", 0),
            ChatRoomData(14, R.drawable.profile, "Chat Room 14", 5, LocalDateTime.now(), "Last message 11", 0),
            ChatRoomData(15, R.drawable.profile, "Chat Room 15", 8, LocalDateTime.now(), "Last message 12", 0),
            ChatRoomData(16, R.drawable.profile, "Chat Room 16", 10, LocalDateTime.now(), "Last message 13", 0),
            ChatRoomData(17, R.drawable.profile, "Chat Room 17", 5, LocalDateTime.now(), "Last message 14", 5),
            ChatRoomData(18, R.drawable.profile, "Chat Room 18", 8, LocalDateTime.now(), "Last message 15", 0),
        )

        val openChatRooms = listOf(
            ChatRoomData(1, R.drawable.profile, "Open Chat Room 1", 20, LocalDateTime.now(), "Last message 4", 1),
            ChatRoomData(2, R.drawable.profile, "Open Chat Room 2", 15, LocalDateTime.now(), "Last message 5", 3),
            ChatRoomData(3, R.drawable.profile, "Open Chat Room 3", 12, LocalDateTime.now(), "Last message 6", 4)
        )
    }
}