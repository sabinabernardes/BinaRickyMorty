package com.bina.design.components

import BinaAppTheme
import SpacingTokens
import TypographyTokens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import com.bina.design.tokens.ColorTokens

@Composable
fun BinaSearchToolbar(
    title: String,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val isPreview = LocalInspectionMode.current

    if (!isPreview) {
        LaunchedEffect(Unit) {
            focusManager.clearFocus()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ColorTokens.Primary)
            .padding(SpacingTokens.spacing16)
    ) {
        Text(
            text = title,
            style = TypographyTokens.heading,
            color = ColorTokens.OnPrimary
        )

        Spacer(modifier = Modifier.height(SpacingTokens.spacing8))

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = "Buscar...",
                    style = TypographyTokens.caption,
                    color = ColorTokens.OnBackground.copy(alpha = 0.6f)
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            shape = RoundedCornerShape(SpacingTokens.spacing8),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = ColorTokens.Surface,
                unfocusedContainerColor = ColorTokens.Surface,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = ColorTokens.Primary,
                focusedTextColor = ColorTokens.OnBackground,
                unfocusedTextColor = ColorTokens.OnBackground,
                focusedPlaceholderColor = ColorTokens.OnBackground.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = ColorTokens.OnBackground.copy(alpha = 0.5f)
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BinaSearchToolbarPreview() {
    var search by remember { mutableStateOf("") }

    BinaAppTheme {
        BinaSearchToolbar(
            title = "Bina Rick and Morty",
            query = search,
            onQueryChange = { search = it }
        )
    }
}

