package com.bina.home.presentation.view

import ListCharactersViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.bina.design.components.BinaErrorDialog
import com.bina.design.components.BinaSearchToolbar
import com.bina.design.components.CharacterListItem
import com.bina.home.presentation.CharactersUiState
import com.bina.home.presentation.ListCharactersUiModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharactersScreen(
    viewModel: ListCharactersViewModel = koinViewModel()
) {
    var query by remember { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsState()

    // Inicia busca assim que a tela carregar
    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        BinaSearchToolbar(
            title = "Personagens",
            query = query,
            onQueryChange = {
                query = it
                viewModel.getCharacters(query)
            }
        )

        when (val state = uiState) {
            is CharactersUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is CharactersUiState.Success -> {
                val characters = state.data.collectAsLazyPagingItems()
                CharacterList(
                    characters = characters,
                    onRetry = { characters.retry() }
                )
            }

            is CharactersUiState.Error -> {
                BinaErrorDialog(
                    message = state.message ?: "Erro desconhecido",
                    onDismiss = { viewModel.clearError() },
                    onRetry = { viewModel.onRetry() }
                )
            }
        }
    }
}

@Composable
fun CharacterList(
    characters: LazyPagingItems<ListCharactersUiModel>,
    onRetry: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters.itemCount) { index ->
            characters[index]?.let { character ->
                CharacterListItem(
                    painter = rememberImagePainter(data = character.imageUrl ?: ""),
                    name = character.name ?: "Desconhecido",
                    onClick = { /* navegar futuramente */ }
                )
            }
        }

        when (val appendState = characters.loadState.append) {
            is LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            is LoadState.Error -> {
                item {
                    BinaErrorDialog(
                        message = "Erro ao carregar mais personagens",
                        onDismiss = {},
                        onRetry = { onRetry() }
                    )
                }
            }

            else -> Unit
        }
    }
}
