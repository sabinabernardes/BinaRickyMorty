package com.bina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = HomeRoute.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(HomeRoute.route) {
            // Chamará HomeScreen do módulo :home
        }
        composable(FeatureRoute.route) {
            // Chamará FeatureScreen do módulo :feature
        }
    }
}

