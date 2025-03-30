package com.bina.binarickymorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterList() {
    BinaRickyMortyTheme {
        ListCharactersScreen()
    }
}


