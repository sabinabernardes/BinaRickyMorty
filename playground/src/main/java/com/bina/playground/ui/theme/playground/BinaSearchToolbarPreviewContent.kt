package com.bina.playground.ui.theme.playground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import com.bina.design.components.BinaErrorDialog
import com.bina.design.components.BinaSearchToolbar
import com.bina.design.components.CharacterListItem

@Composable
fun BinaSearchToolbarPreviewContent() {
    var search by remember { mutableStateOf("") }
    BinaSearchToolbar(
        title = "Bina Rick and Morty",
        query = search,
        onQueryChange = { search = it }
    )
}

@Composable
fun CharacterListItemPreviewContent() {
    CharacterListItem(
        painter = ColorPainter(Color.LightGray),
        name = "Rick Sanchez"
    )
}

@Composable
fun BinaErrorDialogPreviewContent() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        BinaErrorDialog(
            message = "Algo deu errado",
            onDismiss = { showDialog = false },
            onRetry = {}
        )
    }
}
