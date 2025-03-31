package com.bina.home.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.bina.design.components.BinaErrorDialog
import com.bina.design.components.BinaSearchToolbar
import com.bina.design.components.CharacterListItem
import com.bina.home.presentation.ListCharactersUiModel
import com.bina.home.presentation.ListCharactersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharactersScreen(
    viewModel: ListCharactersViewModel = koinViewModel()
) {
    // Estado local da busca
    val queryState = remember { mutableStateOf("") }
    val query by queryState

    // Observa os dados da ViewModel
    val listCharacters by viewModel.listCharactersUiModel.collectAsState()
    val errorMessage by viewModel.error.collectAsState()

    // Aplica filtro com base no texto da busca
    val filteredCharacters = remember(query, listCharacters) {
        if (query.isBlank()) {
            listCharacters
        } else {
            listCharacters.filter { it.name?.contains(query, ignoreCase = true) == true }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Barra de busca no topo
        BinaSearchToolbar(
            title = "Personagens",
            query = query,
            onQueryChange = { queryState.value = it }
        )

        // Lista filtrada de personagens
        CharacterList(characters = filteredCharacters)
    }

    // Exibe diálogo de erro, se houver
    errorMessage?.let { message ->
        BinaErrorDialog(
            message = message,
            onDismiss = { viewModel.clearError() },
            onRetry = { viewModel.onRetry() }
        )
    }
}

@Composable
fun CharacterList(characters: List<ListCharactersUiModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = characters,
            key = { it.id ?: it.hashCode() }
        ) { character ->
            val imageUrl = character.image ?: ""
            CharacterListItem(
                painter = rememberImagePainter(data = imageUrl),
                name = character.name ?: "Desconhecido",
                onClick = { /* navegar pro detalhe futuro */ }
            )
        }
    }
}

// Descomente esse Preview se ele não estiver causando erro de compilação.
// Caso esteja, mantenha comentado até resolver as dependências de preview.

/*
@Preview(showBackground = true)
@Composable
fun ListCharactersScreenPreview() {
    var query by remember { mutableStateOf("") }

    val mockCharacters = listOf(
        ListCharactersUiModel(id = 1, name = "Rick Sanchez", image = "", status = "Alive"),
        ListCharactersUiModel(id = 2, name = "Morty Smith", image = "", status = "Alive"),
        ListCharactersUiModel(id = 3, name = "Summer Smith", image = "", status = "Alive"),
        ListCharactersUiModel(id = 4, name = "Beth Smith", image = "", status = "Alive"),
        ListCharactersUiModel(id = 5, name = "Jerry Smith", image = "", status = "Alive")
    )

    val filteredCharacters = if (query.isBlank()) {
        mockCharacters
    } else {
        mockCharacters.filter { it.name?.contains(query, ignoreCase = true) == true }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        BinaSearchToolbar(
            title = "Personagens",
            query = query,
            onQueryChange = { query = it }
        )

        CharacterList(characters = filteredCharacters)
    }
}
*/
