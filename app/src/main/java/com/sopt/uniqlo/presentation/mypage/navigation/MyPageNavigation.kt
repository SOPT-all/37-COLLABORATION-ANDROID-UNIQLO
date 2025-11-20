package com.sopt.uniqlo.presentation.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.MainTabRoute
import com.sopt.uniqlo.presentation.mypage.MyPageRoute
import kotlinx.serialization.Serializable

fun NavController.navigateMyPage(
    navOptions: NavOptions? = null
) {
    navigate(MyPage, navOptions)
}

fun NavGraphBuilder.myPageGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<MyPage> {
        MyPageRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data object MyPage: MainTabRoute