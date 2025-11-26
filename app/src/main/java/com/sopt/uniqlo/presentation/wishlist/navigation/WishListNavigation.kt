package com.sopt.uniqlo.presentation.wishlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.MainTabRoute
import com.sopt.uniqlo.presentation.wishlist.WishListRoute
import kotlinx.serialization.Serializable

fun NavController.navigateWishList(
    navOptions: NavOptions? = null
) {
    navigate(WishList, navOptions)
}

fun NavGraphBuilder.wishListGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<WishList> {
        WishListRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data object WishList: MainTabRoute