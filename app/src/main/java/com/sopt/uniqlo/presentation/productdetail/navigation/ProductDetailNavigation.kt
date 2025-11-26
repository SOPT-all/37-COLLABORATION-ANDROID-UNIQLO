package com.sopt.uniqlo.presentation.productdetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.Route
import com.sopt.uniqlo.presentation.productdetail.ProductDetailRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToProductDetail(
    productId: Int,
    navOptions: NavOptions? = null
) {
    navigate(ProductDetail(productId = productId), navOptions)
}

fun NavGraphBuilder.productDetailGraph(
    paddingValues: PaddingValues,
){
    composable<ProductDetail> {
        ProductDetailRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data class ProductDetail(val productId: Int) : Route