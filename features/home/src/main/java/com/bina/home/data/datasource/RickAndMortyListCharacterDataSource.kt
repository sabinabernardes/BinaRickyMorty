package com.bina.home.data.datasource

import androidx.paging.PagingData
import com.bina.home.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyListCharacterDataSource {
    fun getCharacters(query: String): Flow<PagingData<ListCharactersModel.Results>>
}