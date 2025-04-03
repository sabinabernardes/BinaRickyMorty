package com.bina.binarickymorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bina.binarickymorty.presentation.view.ListCharactersScreen
import com.bina.binarickymorty.ui.theme.BinaRickyMortyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinaRickyMortyTheme {
                ListCharactersScreen()
            }
        }
//        setContent {
//            BinaAppTheme {
//                val navController = rememberNavController()
//                AppNavGraph(navController)
//            }
//        }
    }
}
