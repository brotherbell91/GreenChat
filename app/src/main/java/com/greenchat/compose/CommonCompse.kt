package com.greenchat.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

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