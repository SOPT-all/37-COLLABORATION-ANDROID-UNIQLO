package com.sopt.uniqlo.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.uniqlo.R
import com.sopt.uniqlo.core.navigation.MainTabRoute
import com.sopt.uniqlo.core.navigation.Route
import com.sopt.uniqlo.presentation.category.navigation.Category
import com.sopt.uniqlo.presentation.home.navigation.Home
import com.sopt.uniqlo.presentation.mypage.navigation.MyPage
import com.sopt.uniqlo.presentation.wishlist.navigation.WishList

enum class MainTab(
    @param:DrawableRes val selectedIcon: Int,
    @param:DrawableRes val unselectedIcon: Int,
    @param:StringRes val contentDescription: Int,
    val route: MainTabRoute,
) {
    HOME(
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home,
        contentDescription = R.string.home,
        route = Home
    ),

    CATEGORY(
        selectedIcon = R.drawable.ic_menu_filled,
        unselectedIcon = R.drawable.ic_menu,
        contentDescription = R.string.category,
        route = Category
    ),

    WISHLIST(
        selectedIcon = R.drawable.ic_heart_filled,
        unselectedIcon = R.drawable.ic_heart,
        contentDescription = R.string.wishlist,
        route = WishList
    ),

    MYPAGE(
        selectedIcon = R.drawable.ic_mypage_filled,
        unselectedIcon = R.drawable.ic_mypage,
        contentDescription = R.string.mypage,
        route = MyPage
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}