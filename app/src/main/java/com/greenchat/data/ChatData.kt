package com.greenchat.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "chat")
data class ChatData(
    @PrimaryKey(autoGenerate = true) @JvmField val id: Int = 0,
//    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var unreadCount: Int = -1,
    var time: LocalDateTime = LocalDateTime.now(),
    var content: String = "",
)