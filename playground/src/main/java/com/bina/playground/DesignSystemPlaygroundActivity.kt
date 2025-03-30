package com.bina.playground

import BinaAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bina.playground.ui.theme.playground.DesignSystemPlaygroundScreen


class DesignSystemPlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinaAppTheme {
                DesignSystemPlaygroundScreen()
            }
        }
    }
}
