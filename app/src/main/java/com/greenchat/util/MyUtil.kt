package com.greenchat.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.greenchat.data.ChatRoomData
import com.greenchat.data.ChatRoomListData

fun findChatRoomDataById(chatRooms: List<ChatRoomData>, id: Int): ChatRoomData? {
    var low = 0
    var high = chatRooms.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val midVal = chatRooms[mid]

        when {
            midVal.id < id -> low = mid + 1
            midVal.id > id -> high = mid - 1
            else -> return midVal
        }
    }
    return null
}

fun findChatRoomListDataById(chatRooms: List<ChatRoomListData>, id: Int): ChatRoomListData? {
    var low = 0
    var high = chatRooms.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val midVal = chatRooms[mid]

        when {
            midVal.id < id -> low = mid + 1
            midVal.id > id -> high = mid - 1
            else -> return midVal
        }
    }
    return null
}

fun dialPhoneNumber(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$phoneNumber")
    context.startActivity(intent)
}