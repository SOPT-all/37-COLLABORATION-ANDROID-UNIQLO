package com.sopt.uniqlo.presentation.dummy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.uniqlo.core.navigation.Route
import com.sopt.uniqlo.presentation.dummy.DummyRoute
import kotlinx.serialization.Serializable

fun NavController.navigateDummy(
    navOptions: NavOptions? = null
) {
    navigate(Dummy, navOptions)
}

fun NavGraphBuilder.dummyGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Dummy> {
        DummyRoute()
    }
}


@Serializable
data object Dummy: Route