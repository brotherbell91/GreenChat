package com.greenchat.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.greenchat.compose.ChatRoomListScreen
import com.greenchat.compose.CustomBottomBar
import com.greenchat.compose.CustomTopAppBar
import com.greenchat.compose.FloatingButton
import com.greenchat.compose.HomeScreen
import com.greenchat.compose.LoginScreen
import com.greenchat.compose.MessageListScreen
import com.greenchat.compose.MoreScreen
import com.greenchat.compose.OrganizationScreen
import com.greenchat.compose.PermissionScreen
import com.greenchat.compose.SplashScreen
import com.greenchat.data.ChatRoomData
import com.greenchat.data.EmployeeData
import com.greenchat.data.MessageData
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.viewmodel.MyViewModel

sealed class Screen(val route: String) {
    object Permission : Screen("permission")
    object Login : Screen("login")
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Organization : Screen("organization")
    object ChatList : Screen("chat_list")
    object MessageList : Screen("message_list")
    object More : Screen("more")
}

@Composable
fun NavigationMain(viewModel: MyViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Permission.route) {
        composable(Screen.Permission.route) { PermissionScreen(navController, viewModel) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(viewModel) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationHome(
    viewModel: MyViewModel,
    onEmployeeSelected: (EmployeeData) -> Unit,
    onChatRoomSelected: (ChatRoomData, Int) -> Unit,
    onMessageSelected: (MessageData, Int) -> Unit,
    onFloatingChatRoomSelected: () -> Unit,
    onFloatingMessageSelected: () -> Unit,
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = { CustomTopAppBar(false, onClose = {}) },
        bottomBar = { CustomBottomBar(navController) }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = colorPrimary
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = ghost_white),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Organization.route,
                    modifier = Modifier
                        .background(ghost_white)
                ) {
                    composable(Screen.Organization.route) { OrganizationScreen(onEmployeeSelected, viewModel) }
                    composable(Screen.ChatList.route) { ChatRoomListScreen(onChatRoomSelected, viewModel)
                        FloatingButton(openDashboard = {onFloatingChatRoomSelected()}, image = Icons.Default.Add)}
                    composable(Screen.MessageList.route) { MessageListScreen(onMessageSelected, viewModel)
                        FloatingButton(openDashboard = {onFloatingMessageSelected()}, image = Icons.Default.Edit)}
                    composable(Screen.More.route) { MoreScreen(viewModel) }
                }
            }
        }
    }
}