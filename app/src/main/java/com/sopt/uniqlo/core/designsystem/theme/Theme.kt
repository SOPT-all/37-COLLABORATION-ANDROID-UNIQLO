package com.sopt.uniqlo.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val localUniqloColors = staticCompositionLocalOf { defaultUniqloColors }

val localUniqloTypography = staticCompositionLocalOf { defaultUniqloTypography }

private val lightColorScheme = lightColorScheme(
    primary = Black,
    background = White,
    surface = White,
    onPrimary = White,
    onBackground = Black,
    onSurface = Black
)

object UniqloTheme {
    val colors: UniqloColors
        @Composable
        @ReadOnlyComposable
        get() = localUniqloColors.current

    val typography: UniqloTypography
        @Composable
        @ReadOnlyComposable
        get() = localUniqloTypography.current
}

@Composable
fun ProvideUniqloColorsAndTypography(
    colors: UniqloColors,
    typography: UniqloTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localUniqloColors provides colors,
        localUniqloTypography provides typography,
        content = content
    )
}

@Composable
fun UniqloTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    ProvideUniqloColorsAndTypography(
        colors = defaultUniqloColors,
        typography = defaultUniqloTypography
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme,
            content = content
        )
    }
}