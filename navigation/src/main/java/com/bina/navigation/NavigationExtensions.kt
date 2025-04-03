package com.bina.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateSafe(route: String) {
    if (currentDestination?.route != route) {
        navigate(route)
    }
}
