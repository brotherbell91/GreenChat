package com.greenchat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenchat.data.ChatData
import com.greenchat.data.ChatRoomData
import com.greenchat.data.ChatRoomListData
import com.greenchat.data.DepartmentData
import com.greenchat.data.EmployeeData
import com.greenchat.data.MessageData
import com.greenchat.data.MessageListData
import com.greenchat.data.PermissionData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _permissionData = MutableStateFlow<List<PermissionData>>(emptyList())
    val permissionData = _permissionData.asStateFlow()
    private val _myData = MutableStateFlow<EmployeeData?>(null)
    val myData = _myData.asStateFlow()
    private val _departmentData = MutableStateFlow<DepartmentData?>(null)
    val departmentData = _departmentData.asStateFlow()
    private val _buddyData = MutableStateFlow<DepartmentData?>(null)
    val buddyData = _buddyData.asStateFlow()
    private val _chatRoomData = MutableStateFlow<List<ChatRoomData>>(emptyList())
    val chatRoomData = _chatRoomData.asStateFlow()
    private val _openChatRoomData = MutableStateFlow<List<ChatRoomData>>(emptyList())
    val openChatRoomData = _openChatRoomData.asStateFlow()
    private val _chatRoomListData = MutableStateFlow<List<ChatRoomListData>>(emptyList())
    val chatRoomListData = _chatRoomListData.asStateFlow()
    private val _openChatRoomListData = MutableStateFlow<List<ChatRoomListData>>(emptyList())
    val openChatRoomListData = _openChatRoomListData.asStateFlow()
    private val _receiveMessageData = MutableStateFlow<List<MessageData>>(emptyList())
    val receiveMessageData = _receiveMessageData.asStateFlow()
    private val _sendMessageData = MutableStateFlow<List<MessageData>>(emptyList())
    val sendMessageData = _sendMessageData.asStateFlow()
    private val _receiveMessageListData = MutableStateFlow<List<MessageListData>>(emptyList())
    val receiveMessageListData = _receiveMessageListData.asStateFlow()
    private val _sendMessageListData = MutableStateFlow<List<MessageListData>>(emptyList())
    val sendMessageListData = _sendMessageListData.asStateFlow()

    init {
        loadMessages()
    }

    private fun loadMessages() {
        viewModelScope.launch {
            _permissionData.value = PermissionData.permissions
            _myData.value = EmployeeData.myData
            _departmentData.value = DepartmentData.organizationDepartment
            _buddyData.value = DepartmentData.organizationBuddy
            _chatRoomData.value = ChatRoomData.chatRoom
            _openChatRoomData.value = ChatRoomData.openChatRoom
            _chatRoomListData.value = ChatRoomListData.chatRooms
            _openChatRoomListData.value = ChatRoomListData.openChatRooms
            _receiveMessageData.value = MessageData.receiveMessage
            _sendMessageData.value = MessageData.sendMessage
            _receiveMessageListData.value = MessageListData.receiveMessages
            _sendMessageListData.value = MessageListData.sendMessages
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