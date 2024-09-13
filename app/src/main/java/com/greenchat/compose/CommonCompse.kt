package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.greenchat.R
import com.greenchat.navigation.Screen
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(backButton : Boolean, onClose: () -> Unit, title: String? = null) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                if(backButton){
                    IconButton(
                        modifier = Modifier.align(Alignment.CenterStart),
                        onClick = onClose
                    ) {
                        Image(
                            modifier = Modifier.size(22.dp),
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "dashboard_search",
                            colorFilter = ColorFilter.tint(Color.White),
                        )
                    }
                }
                Text(
                    text = title ?: stringResource(id = R.string.app_name),
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                        fontSize = 22.sp
                    )
                )
//                IconButton(
//                    modifier = Modifier.align(Alignment.CenterEnd),
//                    onClick = { }
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_search),
//                        contentDescription = "dashboard_search"
//                    )
//                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorPrimary,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTopAppBar() {
    CustomTopAppBar(true, onClose = {})
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    val items = listOf(Screen.Organization, Screen.ChatList, Screen.MessageList, Screen.More)
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    Column(
        modifier = Modifier
            .wrapContentSize()
            .height(110.dp)
    ) {
        NavigationBar(
            containerColor = ghost_white
        ) {
            items.forEachIndexed { index, screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationBarItem(
                    icon = {
                        when (index) {
                            0 -> TabIcons(ImageBitmap.imageResource(id = R.drawable.organization), isSelected)
                            1 -> TabIcons(ImageBitmap.imageResource(id = R.drawable.chat), isSelected)
                            2 -> TabIcons(ImageBitmap.imageResource(id = R.drawable.message), isSelected)
                            3 -> TabIcons(ImageBitmap.imageResource(id = R.drawable.more), isSelected)
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ghost_white,
                        unselectedTextColor = ghost_white,
                        indicatorColor = ghost_white,
                    ),
                    selected = isSelected,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    alwaysShowLabel = false,
                )
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

@Composable
fun todayCheck(time: LocalDateTime) : String{
    val currentDate = remember { LocalDate.now() }
    val someDate = time.toLocalDate()
    val isToday = currentDate.isEqual(someDate)
    val isYesterday = currentDate.minusDays(1).isEqual(someDate)
    val isThisYear = currentDate.year == someDate.year

    val timeFormatter = DateTimeFormatter.ofPattern("a h:mm").withLocale(Locale.ENGLISH)
    val monthDayFormatter = DateTimeFormatter.ofPattern("MMM d").withLocale(Locale.ENGLISH)
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy. M. d.")

    return when {
        isToday -> time.format(timeFormatter)
        isYesterday -> "Yesterday"
        isThisYear -> time.format(monthDayFormatter)
        else -> time.format(dateFormatter)
    }
}

@Composable
fun FloatingButton(openDashboard: () -> Unit, image : ImageVector){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { openDashboard() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(32.dp),
            containerColor = colorPrimary,
            contentColor = Color.White,
        ) {
            Icon(image, "Icon.")
        }
    }
}

@Composable
fun FloatingButton(openDashboard: () -> Unit, image : Int){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { openDashboard() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(32.dp),
            containerColor = colorPrimary,
            contentColor = Color.White,
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = "Icon.",
                tint = Color.White,
                modifier = Modifier
                    .padding(12.dp)
                    .size(25.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFloatingButton(){
    FloatingButton(openDashboard = {}, Icons.Default.Edit )
}