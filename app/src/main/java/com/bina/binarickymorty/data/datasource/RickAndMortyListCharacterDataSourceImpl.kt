package com.bina.binarickymorty.data.datasource

import com.bina.binarickymorty.data.api.RickAndMortyApi
import com.bina.binarickymorty.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RickAndMortyListCharacterDataSourceImpl(
    private val apiService: RickAndMortyApi
) : RickAndMortyListCharacterDataSource {
    override suspend fun getListCharacters(): Flow<ListCharactersModel> {
        return flow{
            emit(
                apiService.getListCharacters()
            )}
    }
}