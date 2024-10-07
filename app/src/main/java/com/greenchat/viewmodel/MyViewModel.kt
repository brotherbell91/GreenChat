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
import com.greenchat.data.MoreData
import com.greenchat.data.PermissionData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime

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
    private val _moreData = MutableStateFlow<List<MoreData>>(emptyList())
    val moreData = _moreData.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
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
            _moreData.value = MoreData.mores
        }
    }

    fun sendChat(content: String, id: Int, type: Int, newChatRoomData: ChatRoomData) {
        viewModelScope.launch {
            val existingChatRoomData = _chatRoomData.value.find { it.id == id }
            if (existingChatRoomData == null) {
                handleNewChatRoom(content, id, newChatRoomData)
            } else {
                val (chatRoomData, chatRoomListData) = if (type == 0) {
                    _chatRoomData to _chatRoomListData
                } else {
                    _openChatRoomData to _openChatRoomListData
                }

                updateChatRoomData(chatRoomData, id, content)
                updateChatRoomListData(chatRoomListData, id, content)
            }
        }
    }

    private fun handleNewChatRoom(content: String, id: Int, newChatRoomData: ChatRoomData) {
        val newChatData = ChatData(
            id = 1,
            imageRes = myData.value!!.imageRes,
            name = myData.value!!.name,
            unreadCount = 1,
            time = LocalDateTime.now(),
            content = content
        )
        val updatedNewChatRoomData = newChatRoomData.copy(chats = listOf(newChatData))
        _chatRoomData.value += listOf(updatedNewChatRoomData)

        val newChatRoomListData = ChatRoomListData(
            id = id,
            imageRes = newChatRoomData.imageRes,
            name = newChatRoomData.name,
            participantsCount = newChatRoomData.participantsCount,
            lastChatTime = LocalDateTime.now(),
            lastChat = content,
            unreadCount = 0
        )
        _chatRoomListData.value = listOf(newChatRoomListData) + _chatRoomListData.value
    }

    private fun updateChatRoomData(chatRoomData: MutableStateFlow<List<ChatRoomData>>, id: Int, content: String) {
        val updatedData = chatRoomData.value.map { roomData ->
            if (roomData.id == id) {
                val newChatData = ChatData(
                    id = roomData.chats.size + 1,
                    imageRes = myData.value!!.imageRes,
                    name = myData.value!!.name,
                    unreadCount = 1,
                    time = LocalDateTime.now(),
                    content = content
                )
                roomData.copy(chats = roomData.chats + newChatData)
            } else {
                roomData
            }
        }
        chatRoomData.value = updatedData
    }

    private fun updateChatRoomListData(chatRoomListData: MutableStateFlow<List<ChatRoomListData>>, id: Int, content: String) {
        val updatedListData = chatRoomListData.value.map { listData ->
            if (listData.id == id) {
                listData.copy(
                    lastChatTime = LocalDateTime.now(),
                    lastChat = content,
                    unreadCount = 0
                )
            } else {
                listData
            }
        }
        val sortedListData = updatedListData.partition { it.id == id }
            .let { (updated, others) -> updated + others }
        chatRoomListData.value = sortedListData
    }

    fun sendMessage(content: String, id: Int, subject: String, toText: String, receiverCount: Int) {
        viewModelScope.launch {
            val existingMessageData = _sendMessageData.value.find { it.id == id }
            if (existingMessageData == null) {
                handleNewMessage(content, id, subject, toText, receiverCount)
            }
        }
    }

    private fun handleNewMessage(content: String, id: Int, subject: String, toText: String, receiverCount: Int) {
        val newMessageData = MessageData(
            id = id,
            imageRes = myData.value!!.imageRes,
            name = subject,
            receiverCount = receiverCount,
            time = LocalDateTime.now(),
            sender  = myData.value!!.name,
            receiver  = toText,
            content  = content
        )
        _sendMessageData.value += listOf(newMessageData)

        val newMessageListData = MessageListData(
            id = id,
            imageRes = newMessageData.imageRes,
            name = newMessageData.name,
            receiverCount = newMessageData.receiverCount,
            time = newMessageData.time,
            sender = newMessageData.sender,
            receiver = newMessageData.receiver,
            unreadCount = 0
        )
        _sendMessageListData.value = listOf(newMessageListData) + _sendMessageListData.value
    }

    fun deleteUnreadCountChat(id: Int, type: Int){
        val anyChatRoomListData = if (type == 0) _chatRoomListData else _openChatRoomListData
        anyChatRoomListData.update { list ->
            list.map { item ->
                if (item.id == id) item.copy(unreadCount = 0) else item
            }
        }
    }

    fun deleteUnreadCountMessage(id: Int, type: Int){
        if(type == 0){
            _receiveMessageListData.update { list ->
                list.map { item ->
                    if (item.id == id) item.copy(unreadCount = 0) else item
                }
            }
        }
    }

    fun changeMoreDataBoolean(id: Int, type: Int){
        if(type == 2 || type == 3){
            _moreData.update { list ->
                list.map { item ->
                    if (item.id == id) item.copy(data = (!item.data.toBoolean()).toString()) else item
                }
            }
        }
    }
}