package com.bina.design.components

import BinaAppTheme
import TypographyTokens
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bina.design.tokens.ColorTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BinaToolbar(
    title: String,
    onBackClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TypographyTokens.heading,
                color = ColorTokens.OnPrimary
            )
        },
        navigationIcon = {
            onBackClick?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = ColorTokens.OnPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ColorTokens.Primary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun BinaToolbarPreview() {
    BinaAppTheme {
        BinaToolbar(
            title = "Tela de Personagens",
            onBackClick = {}
        )
    }
}

