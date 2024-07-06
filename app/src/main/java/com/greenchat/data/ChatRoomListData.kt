package com.greenchat.data

import android.os.Parcelable
import com.greenchat.R
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class ChatRoomListData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var participantsCount: Int = -1,
    var lastChatTime: LocalDateTime = LocalDateTime.now(),
    var lastChat: String = "",
    var unreadCount: Int = -1,
) : Parcelable {
    companion object{
        val chatRooms = listOf(
            ChatRoomListData(1, R.drawable.profile, "Chat Room 1", 10, LocalDateTime.now(), "Last message 1", 2),
            ChatRoomListData(2, R.drawable.profile, "Chat Room 2", 5, LocalDateTime.now(), "Last message 2", 6),
            ChatRoomListData(3, R.drawable.profile, "Chat Room 3", 8, LocalDateTime.of(2024, 6,6, 8, 16,32 ), "Last message 3", 5),
            ChatRoomListData(4, R.drawable.profile, "Chat Room 4", 8, LocalDateTime.of(2024, 6,7, 8, 16,32 ), "Last message 3", 5),
            ChatRoomListData(5, R.drawable.profile, "Chat Room 5", 8, LocalDateTime.of(2023, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomListData(6, R.drawable.profile, "Chat Room 6", 8, LocalDateTime.of(2022, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomListData(7, R.drawable.profile, "Chat Room 7", 10, LocalDateTime.now(), "Last message 4", 0),
            ChatRoomListData(8, R.drawable.profile, "Chat Room 8", 5, LocalDateTime.now(), "Last message 5", 0),
            ChatRoomListData(9, R.drawable.profile, "Chat Room 9", 8, LocalDateTime.now(), "Last message 6", 2),
            ChatRoomListData(10, R.drawable.profile, "Chat Room 10", 10, LocalDateTime.now(), "Last message 7", 1),
            ChatRoomListData(11, R.drawable.profile, "Chat Room 11", 5, LocalDateTime.now(), "Last message 8", 0),
            ChatRoomListData(12, R.drawable.profile, "Chat Room 12", 8, LocalDateTime.now(), "Last message 9", 3),
            ChatRoomListData(13, R.drawable.profile, "Chat Room 13", 10, LocalDateTime.now(), "Last message 10", 0),
            ChatRoomListData(14, R.drawable.profile, "Chat Room 14", 5, LocalDateTime.now(), "Last message 11", 0),
            ChatRoomListData(15, R.drawable.profile, "Chat Room 15", 8, LocalDateTime.now(), "Last message 12", 0),
            ChatRoomListData(16, R.drawable.profile, "Chat Room 16", 10, LocalDateTime.now(), "Last message 13", 0),
            ChatRoomListData(17, R.drawable.profile, "Chat Room 17", 5, LocalDateTime.now(), "Last message 14", 5),
            ChatRoomListData(18, R.drawable.profile, "Chat Room 18", 8, LocalDateTime.now(), "Last message 15", 0),
        )

        val openChatRooms = listOf(
            ChatRoomListData(1, R.drawable.profile, "Open Chat Room 1", 20, LocalDateTime.now(), "Last message 4", 1),
            ChatRoomListData(2, R.drawable.profile, "Open Chat Room 2", 15, LocalDateTime.now(), "Last message 5", 3),
            ChatRoomListData(3, R.drawable.profile, "Open Chat Room 3", 12, LocalDateTime.now(), "Last message 6", 4)
        )
    }
}