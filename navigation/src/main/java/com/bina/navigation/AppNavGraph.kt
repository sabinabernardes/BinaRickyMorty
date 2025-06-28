package com.bina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bina.details.presentation.view.DetailsScreen
import com.bina.home.presentation.view.ListCharactersScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = HomeRoute.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = HomeRoute.route) {
            ListCharactersScreen(
                navController = navController
            )
        }

        composable(route = "details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                DetailsScreen(
                    characterId = id,
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}

