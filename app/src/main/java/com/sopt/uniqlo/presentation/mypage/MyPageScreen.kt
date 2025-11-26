package com.sopt.uniqlo.presentation.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues
) {
    MyPageScreen(
        paddingValues = paddingValues
    )
}

@Composable
private fun MyPageScreen(
    paddingValues: PaddingValues
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(
            text = "MyPage"
        )
    }
}
