package com.sopt.uniqlo.presentation.productlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.Route
import com.sopt.uniqlo.presentation.productlist.ProductListRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToProductList(
    navOptions: NavOptions? = null
) {
    navigate(ProductList, navOptions)
}

fun NavGraphBuilder.productListGraph(
    paddingValues: PaddingValues,
    navigateToDetail: (Int) -> Unit
) {
    composable<ProductList> {
        ProductListRoute(
            paddingValues = paddingValues,
            onProductClick = navigateToDetail
        )
    }
}

@Serializable
data object ProductList : Route