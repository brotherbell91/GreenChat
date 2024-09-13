package com.greenchat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenchat.data.ChatData
import com.greenchat.data.ChatRoomData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatRoomViewModel : ViewModel() {
    private val _chatData = MutableStateFlow<List<ChatData>>(emptyList())
    val chatData = _chatData.asStateFlow()
    private val _chatRoomData = MutableStateFlow<List<ChatRoomData>>(emptyList())
    val chatRoomData = _chatRoomData.asStateFlow()

    init {
        loadMessages()
    }

    private fun loadMessages() {
        viewModelScope.launch {
            //로컬영역 추가시
        }
    }

    fun sendMessage(chatData: ChatData) {
        viewModelScope.launch {
            //임시
            _chatData.value += chatData
        }
    }

    fun clearMessages() {
        viewModelScope.launch {
            //임시
            _chatData.value = emptyList()
            _chatRoomData.value = emptyList()
        }
    }

}