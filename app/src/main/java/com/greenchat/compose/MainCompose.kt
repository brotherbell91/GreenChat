package com.greenchat.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greenchat.R
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val selectedIndex = remember { mutableStateOf(0) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomTopAppBar()
            },
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorPrimary
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ghost_white),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {
                        Box {
                            when (selectedIndex.value) {
                                0 -> OrganizationScreen() //조직
                                1 -> {} //채팅리스트
                                2 -> {} //쪽지리스트
                                3 -> {} //더보기
                            }
                        }
                    }
                }
            },
            bottomBar = {
                CustomBottomBar(selectedIndex = selectedIndex)
            },
        )
    }
}

@Composable
fun CustomBottomBar(selectedIndex: MutableState<Int>) {
    val listItems = listOf("Home", "Location", "Cart", "Profile")
    Column(
        modifier = Modifier
            .wrapContentSize()
            .height(110.dp)
    ) {
        NavigationBar(
            containerColor = ghost_white){
            listItems.forEachIndexed { index, label ->
                val isSelected = selectedIndex.value == index
                NavigationBarItem(
                    icon = {
                        when (index) {
                            0 -> {
                                TabIcons(
                                    ImageBitmap.imageResource(id = R.drawable.organization),
                                    isSelected
                                )
                            }
                            1 -> {
                                TabIcons(
                                    ImageBitmap.imageResource(id = R.drawable.chat),
                                    isSelected
                                )
                            }
                            2 -> {
                                TabIcons(
                                    ImageBitmap.imageResource(id = R.drawable.message),
                                    isSelected
                                )
                            }
                            3 -> {
                                TabIcons(
                                    ImageBitmap.imageResource(id = R.drawable.more),
                                    isSelected,
                                )
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ghost_white,
                        unselectedTextColor = ghost_white,
                        indicatorColor = ghost_white,
                    ),
                    selected = isSelected,
                    onClick = { selectedIndex.value = index },
                    alwaysShowLabel = false,)
            }
        }
    }

}

@Composable
fun TabIcons(icon: ImageBitmap, isTintColor: Boolean) {
    if (isTintColor) {
        Image(
            modifier = Modifier.size(24.dp),
            bitmap = icon,
            colorFilter = ColorFilter.tint(colorPrimary),
            contentScale = ContentScale.Fit,
            contentDescription = "tb_icon_if",
        )
    } else {
        Image(
            modifier = Modifier.size(24.dp),
            bitmap = icon,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(image_gray),
            contentDescription = "tb_icon_else",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    MainScreen()
}