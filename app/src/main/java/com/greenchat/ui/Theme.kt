package com.greenchat.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val ColorPalette = lightColorScheme(
    primary = colorPrimary,
    primaryContainer  = colorPrimary,
    secondary = colorPrimary
)

@Composable
fun JetPackComposeTheme(content: @Composable() () -> Unit) {

    MaterialTheme(
        colorScheme = ColorPalette,
        typography = typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}