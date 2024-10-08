package com.greenchat.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.greenchat.R
import com.greenchat.data.ChatRoomData
import com.greenchat.data.EmployeeData
import com.greenchat.data.MessageData
import com.greenchat.navigation.NavigationHome
import com.greenchat.util.dialPhoneNumber
import com.greenchat.viewmodel.MyViewModel

enum class SelectBuddyScreenType {
    CHAT_ROOM, MESSAGE
}

object BackPressHandler {
    var closeUseBackPress: () -> Boolean = { false }
}

@Composable
fun HomeScreen(viewModel: MyViewModel) {
    val context = LocalContext.current

    val myData by viewModel.myData.collectAsState()
    val chatRoomData by viewModel.chatRoomData.collectAsState()

    var selectedEmployee by remember { mutableStateOf<EmployeeData?>(null) }
    var selectedChatRoom by remember { mutableStateOf<ChatRoomData?>(null) }
    var selectedMessage by remember { mutableStateOf<MessageData?>(null) }

    var showSelectBuddyScreen by remember { mutableStateOf(false) }
    var showChatRoomScreen by remember { mutableStateOf(false) }
    var showMessageEditScreen by remember { mutableStateOf(false) }

    var selectBuddyScreenType by remember { mutableStateOf<SelectBuddyScreenType?>(null) }
    var selectChatRoomType by remember { mutableStateOf(0)}
    var selectMessageType by remember { mutableStateOf(0)}
    var selectEmployeeList by remember { mutableStateOf<List<EmployeeData>>(emptyList())}

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        NavigationHome(
            viewModel,
            onEmployeeSelected = { employee ->
                selectedEmployee = employee
            },
            onChatRoomSelected = { chatRoom, type ->
                selectedChatRoom = chatRoom
                selectChatRoomType = type
            },
            onMessageSelected = { message, type ->
                selectedMessage = message
                selectMessageType = type
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
            onProfileChatRoomSelected = {
                selectEmployeeList += employeeData
                showChatRoomScreen = true
                selectedEmployee = null
            },
            onProfileMessageSelected = {
                selectEmployeeList += employeeData
                showMessageEditScreen = true
                selectedEmployee = null
            },
            onProfileCallSelected = {
                dialPhoneNumber(context, employeeData.phone)
            },
            employeeData = employeeData,
            onClose = { selectedEmployee = null }
        )
    }

    selectedChatRoom?.let { chatRoomData ->
        ChatRoomScreen(
            viewModel = viewModel,
            onEmployeeSelected = { /*TODO*/ }, //방안에서 직원 추가
            selectedChatRoomData = chatRoomData,
            type = selectChatRoomType,
            onClose = {
                selectedChatRoom = null
                selectChatRoomType = 0
            }
        )
        viewModel.deleteUnreadCountChat(chatRoomData.id, selectChatRoomType)
    }

    selectedMessage?.let { messageData ->
        MessageScreen(
            messageData = messageData,
            onClose = { selectedMessage = null }
        )
        viewModel.deleteUnreadCountMessage(messageData.id, selectMessageType)
    }

    if(showChatRoomScreen){
        ChatRoomScreen(
            viewModel = viewModel,
            onEmployeeSelected = { /*TODO*/ }, //방안에서 직원 추가
            selectedChatRoomData = ChatRoomData(
                id = chatRoomData.size+1,
                imageRes = R.drawable.profile,
                name = selectEmployeeList[0].name,
                participantsCount = 2,
                participants = listOf(myData!!) + selectEmployeeList,
                chats = emptyList()
            ),
            type = selectChatRoomType,
            onClose = {
                showChatRoomScreen = false
                selectChatRoomType = 0
                selectEmployeeList = emptyList()
            }
        )
    }

    if(showMessageEditScreen){
        MessageEditScreen(
            viewModel = viewModel,
            onEmployeeSelected = { showSelectBuddyScreen = true },
            employeeDataList = selectEmployeeList,
            myData = myData!!,
            onClose = {
                showMessageEditScreen = false
                selectEmployeeList = emptyList()
            }
        )
    }

    if (showSelectBuddyScreen) {
        SelectBuddyScreen(
            viewModel,
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
            selectChatRoomType = 0
            return true
        }

        if(selectedMessage != null){
            selectedMessage = null
            selectMessageType = 0
            return true
        }

        return false
    }

    BackPressHandler.closeUseBackPress = ::closeUseBackPress

}