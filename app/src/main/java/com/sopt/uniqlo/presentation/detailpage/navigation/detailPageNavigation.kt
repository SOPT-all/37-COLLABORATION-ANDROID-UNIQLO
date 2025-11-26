package com.sopt.uniqlo.presentation.detailpage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.Route
import com.sopt.uniqlo.presentation.detailpage.DetailPageRoute
import kotlinx.serialization.Serializable

fun NavController.navigateDetailPage(
    navOptions: NavOptions? = null
) {
    navigate(DetailPage, navOptions)
}

fun NavGraphBuilder.detailPageGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<DetailPage> {
        DetailPageRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data object DetailPage : Route