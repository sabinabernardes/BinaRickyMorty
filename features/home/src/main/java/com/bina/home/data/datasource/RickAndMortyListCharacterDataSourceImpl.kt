package com.bina.home.data.datasource

import com.bina.home.data.api.RickAndMortyApi
import com.bina.home.data.model.ListCharactersModel
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