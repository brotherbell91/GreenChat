package com.greenchat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenchat.data.ChatData
import com.greenchat.data.ChatRoomData
import com.greenchat.data.ChatRoomListData
import com.greenchat.data.DepartmentData
import com.greenchat.data.MessageData
import com.greenchat.data.MessageListData
import com.greenchat.data.PermissionData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _permissionData = MutableStateFlow<List<PermissionData>>(emptyList())
    val permissionData = _permissionData.asStateFlow()
    private val _departmentData = MutableStateFlow<List<DepartmentData>>(emptyList())
    val departmentData = _departmentData.asStateFlow()
    private val _buddyData = MutableStateFlow<List<DepartmentData>>(emptyList())
    val buddyData = _buddyData.asStateFlow()
    private val _chatRoomData = MutableStateFlow<List<ChatRoomData>>(emptyList())
    val chatRoomData = _chatRoomData.asStateFlow()
    private val _chatRoomListData = MutableStateFlow<List<ChatRoomListData>>(emptyList())
    val chatRoomListData = _chatRoomListData.asStateFlow()
    private val _messageData = MutableStateFlow<List<MessageData>>(emptyList())
    val messageData = _messageData.asStateFlow()
    private val _messageListData = MutableStateFlow<List<MessageListData>>(emptyList())
    val messageListData = _messageListData.asStateFlow()

    init {
        loadMessages()
    }

    private fun loadMessages() {
        viewModelScope.launch {
            //로컬영역 추가시
            _permissionData.value = PermissionData.permissions
        }
    }

    fun sendMessage(chatData: ChatData) {
        viewModelScope.launch {
            //임시
//            _chatData.value += chatData
        }
    }

    fun clearMessages() {
        viewModelScope.launch {
            //임시
//            _chatData.value = emptyList()
//            _chatRoomData.value = emptyList()
        }
    }

}