package com.sopt.uniqlo.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val localUniqloColors = staticCompositionLocalOf { defaultUniqloColors }

val localUniqloTypography = staticCompositionLocalOf { defaultUniqloTypography }

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
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = !darkTheme
                }
            }
        }

        MaterialTheme(
            content = content
        )
    }
}