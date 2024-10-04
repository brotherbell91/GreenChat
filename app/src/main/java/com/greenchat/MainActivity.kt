package com.greenchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greenchat.compose.BackPressHandler
import com.greenchat.compose.HomeScreen
import com.greenchat.navigation.NavigationMain
import com.greenchat.viewmodel.MyViewModel

class MainActivity : ComponentActivity() {

    override fun onBackPressed() {
        if(!BackPressHandler.closeUseBackPress()){
            finishAffinity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val viewModel: MyViewModel = viewModel()
            NavigationMain(viewModel)
        }
    }
}