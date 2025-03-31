package com.bina.home.data.datasource

import com.bina.home.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyListCharacterDataSource {
    suspend fun getListCharacters() : Flow<ListCharactersModel>
}