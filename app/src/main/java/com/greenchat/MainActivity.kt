package com.greenchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.greenchat.compose.BackPressHandler
import com.greenchat.compose.HomeScreen
import com.greenchat.navigation.NavigationMain

class MainActivity : ComponentActivity() {

    override fun onBackPressed() {
        if(!BackPressHandler.closeUseBackPress()){
            finishAffinity() //종료하시겠습니까? 얼럿 필요
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            // login -> splash -> home
            NavigationMain()
        }
    }
}