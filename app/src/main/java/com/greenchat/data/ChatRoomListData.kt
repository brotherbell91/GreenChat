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
            ChatRoomListData(1, R.drawable.profile, "Chat Room 1", 5, LocalDateTime.now(), "Last message 1", 0),
            ChatRoomListData(2, R.drawable.profile, "Chat Room 2", 5, LocalDateTime.now(), "Last message 2", 4),
            ChatRoomListData(3, R.drawable.profile, "Chat Room 3", 8, LocalDateTime.of(2024, 6,6, 8, 16,32 ), "Last message 3", 4),
            ChatRoomListData(4, R.drawable.profile, "Chat Room 4", 5, LocalDateTime.of(2024, 6,7, 8, 16,32 ), "Last message 3", 4),
            ChatRoomListData(5, R.drawable.profile, "Chat Room 5", 8, LocalDateTime.of(2023, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomListData(6, R.drawable.profile, "Chat Room 6", 6, LocalDateTime.of(2022, 6,7, 8, 16,32 ), "Last message 3", 0),
            ChatRoomListData(7, R.drawable.profile, "Chat Room 7", 5, LocalDateTime.now(), "Last message 4", 0),
            ChatRoomListData(8, R.drawable.profile, "Chat Room 8", 5, LocalDateTime.now(), "Last message 5", 0),
        )

        val openChatRooms = listOf(
            ChatRoomListData(1, R.drawable.profile, "Open Chat Room 1", 6, LocalDateTime.now(), "Last message 4", 5),
            ChatRoomListData(2, R.drawable.profile, "Open Chat Room 2", 8, LocalDateTime.now(), "Last message 5", 5),
            ChatRoomListData(3, R.drawable.profile, "Open Chat Room 3", 10, LocalDateTime.now(), "Last message 6", 5)
        )
    }
}