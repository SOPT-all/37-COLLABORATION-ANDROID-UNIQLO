package com.sopt.uniqlo.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.uniqlo.core.navigation.MainTabRoute
import com.sopt.uniqlo.core.navigation.Route

enum class MainTab(
    @param:DrawableRes val selectedIcon: Int,
    @param:DrawableRes val unselectedIcon: Int,
    @param:StringRes val contentDescription: Int,
    val route: MainTabRoute,
) {
    // Todo : 탭 추가 예정
    ;

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}