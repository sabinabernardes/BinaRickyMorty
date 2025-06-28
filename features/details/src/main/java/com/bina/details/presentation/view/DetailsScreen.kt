package com.bina.details.presentation.view

import SpacingTokens
import TypographyTokens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bina.design.tokens.ColorTokens
import com.bina.details.presentation.model.CharacterDetailsUiModel
import com.bina.details.presentation.viewmodel.DetailsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = koinViewModel(),
    characterId: Int,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    val characterDetails by viewModel.characterDetails.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.fetchCharacterDetails(characterId)
    }

    Box(modifier = modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            error != null -> {
                Text(
                    text = error ?: "Erro desconhecido",
                    style = TypographyTokens.body,
                    color = ColorTokens.Error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            characterDetails != null -> {
                characterDetails?.let {
                    CharacterDetailsContent(
                        viewModel.characterDetailsUiMapper.map(
                            it
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CharacterDetailsContent(details: CharacterDetailsUiModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpacingTokens.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        details.image?.let {
            AsyncImage(
                model = it,
                contentDescription = details.name,
                modifier = Modifier.size(180.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(SpacingTokens.spacing16))
        Text(
            text = details.name ?: "Sem nome",
            style = TypographyTokens.heading,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Status: ${details.status ?: "-"}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Espécie: ${details.species ?: "-"}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Gênero: ${details.gender ?: "-"}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Origem: ${details.originName ?: "-"}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Localização: ${details.locationName ?: "-"}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Episódios: ${details.episodeCount ?: 0}",
            style = TypographyTokens.body,
            color = ColorTokens.OnBackground
        )
        Text(
            text = "Criado em: ${details.created ?: "-"}",
            style = TypographyTokens.caption,
            color = ColorTokens.OnBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterDetailsContentPreview() {
    CharacterDetailsContent(
        details = com.bina.details.presentation.model.CharacterDetailsUiModel(
            id = 1,
            name = "Rick Sanchez",
            status = "Vivo",
            species = "Humano",
            type = "Cientista",
            gender = "Masculino",
            originName = "Terra (C-137)",
            locationName = "Citadel of Ricks",
            image = null,
            episodeCount = 41,
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )
    )
}
