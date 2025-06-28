package com.bina.navigation

object DetailsRoute : NavigationDestination {
    override val route = "details/{characterId}"
    override val destination = "details_destination"
    fun createRoute(characterId: Int) = "details/$characterId"
}