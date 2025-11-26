package com.sopt.uniqlo.core.extension

import androidx.compose.ui.graphics.Color

fun String.toComposeColor(): Color {
     return Color(android.graphics.Color.parseColor(this))
 }