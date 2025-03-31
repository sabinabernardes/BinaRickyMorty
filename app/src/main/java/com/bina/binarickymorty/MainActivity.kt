package com.bina.binarickymorty

import BinaAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.bina.home.presentation.view.ListCharactersScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDark = isSystemInDarkTheme()
            BinaAppTheme(darkTheme = isDark) {
                ListCharactersScreen()
            }
        }
    }
}
