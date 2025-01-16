package com.bina.binarickymorty.data.datasource

import com.bina.binarickymorty.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyListCharacterDataSource {
    suspend fun getListCharacters() : Flow<ListCharactersModel>
}