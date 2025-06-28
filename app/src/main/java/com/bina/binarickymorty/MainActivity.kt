package com.bina.binarickymorty

import BinaAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.navigation.compose.rememberNavController
import com.bina.navigation.AppNavGraph
import com.bina.navigation.HomeRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDark = isSystemInDarkTheme()
            BinaAppTheme(darkTheme = isDark) {
                AppNavGraph(
                    navController = rememberNavController(),
                    startDestination = HomeRoute.route
                )
            }
        }
    }
}
