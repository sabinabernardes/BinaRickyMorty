package com.bina.design.components

import BinaAppTheme
import TypographyTokens
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BinaErrorDialog(
    message: String,
    onDismiss: () -> Unit,
    onRetry: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Algo deu errado",
                style = TypographyTokens.heading
            )
        },
        text = {
            Text(
                text = message,
                style = TypographyTokens.body
            )
        },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text("Tentar novamente")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Fechar")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BinaErrorDialogPreview() {
    BinaAppTheme {
        BinaErrorDialog(
            message = "Não foi possível carregar os personagens. Verifique sua conexão.",
            onDismiss = {},
            onRetry = {}
        )
    }
}