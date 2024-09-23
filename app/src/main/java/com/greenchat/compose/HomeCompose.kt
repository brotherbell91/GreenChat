package com.greenchat.compose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import com.greenchat.R
import com.greenchat.data.ChatRoomData
import com.greenchat.data.EmployeeData
import com.greenchat.data.MessageData
import com.greenchat.navigation.NavigationHome

enum class SelectBuddyScreenType {
    CHAT_ROOM, MESSAGE
}

object BackPressHandler {
    var closeUseBackPress: () -> Boolean = { false }
}

@Composable
fun HomeScreen() {
    var selectedEmployee by remember { mutableStateOf<EmployeeData?>(null) }
    var selectedChatRoom by remember { mutableStateOf<ChatRoomData?>(null) }
    var selectedMessage by remember { mutableStateOf<MessageData?>(null) }

    var showSelectBuddyScreen by remember { mutableStateOf(false) }
    var showChatRoomScreen by remember { mutableStateOf(false) } //아직
    var showMessageEditScreen by remember { mutableStateOf(false) }

    var selectBuddyScreenType by remember { mutableStateOf<SelectBuddyScreenType?>(null) }
    var selectEmployeeList by remember { mutableStateOf<List<EmployeeData>>(emptyList())}

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        NavigationHome(
            onEmployeeSelected = { employee ->
                selectedEmployee = employee
            },
            onChatRoomSelected = { chatRoom ->
                selectedChatRoom = chatRoom
            },
            onMessageSelected = { message ->
                selectedMessage = message
            },
            onFloatingChatRoomSelected = {
                selectBuddyScreenType = SelectBuddyScreenType.CHAT_ROOM
                showSelectBuddyScreen = true
            },
            onFloatingMessageSelected = {
                selectBuddyScreenType = SelectBuddyScreenType.MESSAGE
                showSelectBuddyScreen = true
            }
        )
    }

    selectedEmployee?.let { employeeData ->
        ProfileScreen(
            employeeData = employeeData,
            onClose = { selectedEmployee = null }
        )
    }

    selectedChatRoom?.let { chatRoomData ->
        ChatRoomScreen(onEmployeeSelected = { /*TODO*/ }, //방안에서 직원 추가
            chatRoomData = chatRoomData,
            onClose = { selectedChatRoom = null }
        )
    }

    selectedMessage?.let { messageData ->
        MessageScreen(
            messageData = messageData,
            onClose = { selectedMessage = null }
        )
    }

    if(showChatRoomScreen){
        ChatRoomScreen(onEmployeeSelected = { /*TODO*/ }, //방안에서 직원 추가
            chatRoomData = ChatRoomData(
                id = ChatRoomData.chatRoom.size,
                imageRes = R.drawable.profile,
                name = selectEmployeeList[0].name,
                participantsCount = 1,
                participants = selectEmployeeList,
                chats = emptyList()
            ),
            onClose = {
                showChatRoomScreen = false
                selectEmployeeList = emptyList()
            }
        )
    }

    if(showMessageEditScreen){
        MessageEditScreen(onEmployeeSelected = { showSelectBuddyScreen = true },
            employeeDataList = selectEmployeeList,
            myData = EmployeeData.myData,
            onClose = {
                showMessageEditScreen = false
                selectEmployeeList = emptyList()
            }
        )
    }

    if (showSelectBuddyScreen) {
        SelectBuddyScreen(
            onEmployeeSelected = { employee ->
                when (selectBuddyScreenType) {
                    SelectBuddyScreenType.CHAT_ROOM -> {
                        selectEmployeeList += employee
                        showChatRoomScreen = true
                    }
                    SelectBuddyScreenType.MESSAGE -> {
                        selectEmployeeList += employee
                        showMessageEditScreen = true
                    }
                    null -> {
                        if(selectEmployeeList.isNotEmpty()) {
                            selectEmployeeList += employee
                        }
                    }
                }
                showSelectBuddyScreen = false
                selectBuddyScreenType = null
            },
            onClose = {
                showSelectBuddyScreen = false
                selectBuddyScreenType = null
            }
        )
    }

    fun closeUseBackPress() : Boolean{
        if(showSelectBuddyScreen){
            showSelectBuddyScreen = false
            selectBuddyScreenType = null
            return true
        }

        if(showChatRoomScreen){
            showChatRoomScreen = false
            selectEmployeeList = emptyList()
            return true
        }

        if(showMessageEditScreen){
            showMessageEditScreen = false
            selectEmployeeList = emptyList()
            return true
        }

        if(selectedEmployee != null){
            selectedEmployee = null
            return true
        }

        if(selectedChatRoom != null){
            selectedChatRoom = null
            return true
        }

        if(selectedMessage != null){
            selectedMessage = null
            return true
        }

        return false
    }

    BackPressHandler.closeUseBackPress = ::closeUseBackPress

}