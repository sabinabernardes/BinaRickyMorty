package com.bina.binarickymorty.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bina.binarickymorty.presentation.ListCharactersUiModel
import com.bina.binarickymorty.presentation.ListCharactersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharactersScreen(
    viewModel: ListCharactersViewModel = koinViewModel()
) {
    val listCharacters = viewModel.listCharactersUiModel.collectAsState(initial = null)
    val errorMessage = viewModel.error.collectAsState(initial = null)

   if (errorMessage.value != null) {
        Text(
            text = errorMessage.value ?: "Unknown error",
            modifier = Modifier.padding(16.dp)
        )
    } else {
        listCharacters.value?.let { characters ->
            CharacterList(characters = characters)
        } ?: run {
            Text(
                text = "Carregando personagens...",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun CharacterList(characters: List<ListCharactersUiModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters) { character ->
            CharacterItem(character = character)
        }
    }
}

@Composable
fun CharacterItem(character: ListCharactersUiModel) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = character.name ?: "Nome desconhecido",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

