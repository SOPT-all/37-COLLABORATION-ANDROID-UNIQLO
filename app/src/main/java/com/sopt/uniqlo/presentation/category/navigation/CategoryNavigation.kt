package com.sopt.uniqlo.presentation.category.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.MainTabRoute
import com.sopt.uniqlo.presentation.category.CategoryRoute
import kotlinx.serialization.Serializable

fun NavController.navigateCategory(
    navOptions: NavOptions? = null
) {
    navigate(Category, navOptions)
}

fun NavGraphBuilder.categoryGraph(
    paddingValues: PaddingValues,
    navigateToProductList : () -> Unit
) {
    composable<Category> {
        CategoryRoute(
            paddingValues = paddingValues,
            navigateToProductList = navigateToProductList
        )
    }
}


@Serializable
data object Category: MainTabRoute