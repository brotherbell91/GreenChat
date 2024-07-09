package com.greenchat.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greenchat.MainActivity
import com.greenchat.R
import com.greenchat.ui.colorPrimary
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(backButton : Boolean, tag: String? = null) {
    val activity = LocalContext.current as? MainActivity
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                if(backButton){
                    IconButton(
                        modifier = Modifier.align(Alignment.CenterStart),
                        onClick = {(activity as MainActivity).removeTopFragment(tag)}
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
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                        fontSize = 22.sp
                    )
                )
                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "dashboard_search"
                    )
                }
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
    CustomTopAppBar(true)
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