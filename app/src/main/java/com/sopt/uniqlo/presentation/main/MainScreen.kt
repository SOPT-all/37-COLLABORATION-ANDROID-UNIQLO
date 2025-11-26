package com.sopt.uniqlo.presentation.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.sopt.uniqlo.core.designsystem.component.UniqloTopbar
import com.sopt.uniqlo.presentation.category.navigation.categoryGraph
import com.sopt.uniqlo.presentation.detailpage.navigation.detailPageGraph
import com.sopt.uniqlo.presentation.dummy.navigation.dummyGraph
import com.sopt.uniqlo.presentation.home.navigation.homeGraph
import com.sopt.uniqlo.presentation.main.component.MainBottomBar
import com.sopt.uniqlo.presentation.mypage.navigation.myPageGraph
import com.sopt.uniqlo.presentation.productlist.navigation.productListGraph
import com.sopt.uniqlo.presentation.wishlist.navigation.wishListGraph
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    appState: MainAppState = rememberMainAppState(),
) {
    val isBottomBarVisible by appState.isBottomBarVisible.collectAsStateWithLifecycle()
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .shadow(
                        elevation = 24.dp,
                    )
                    .background(
                        color = Color.White,
                    )
            ) {
                MainBottomBar(
                    isVisible = isBottomBarVisible,
                    tabs = MainTab.entries.toPersistentList(),
                    currentTab = currentTab,
                    onTabSelected = appState::navigate
                )
            }
        },
        topBar = {
            UniqloTopbar()
        },
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
    ) { innerPadding ->
        NavHost(
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            navController = appState.navController,
            startDestination = appState.startDestination
        ) {
            dummyGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            homeGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            categoryGraph(
                paddingValues = innerPadding,
                navigateToProductList = appState::navigateToProductList
            )

            wishListGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            myPageGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            productListGraph(
                paddingValues = innerPadding,
                navigateToDetail = appState::navigateToProductDetail
            )

            detailPageGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )
        }
    }
}
