package com.bina.home.domain.repository

import androidx.paging.PagingData
import com.bina.home.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow

interface RepositoryRickAndMorty {
    fun getCharacters(query: String): Flow<PagingData<ListCharactersModel.Results>>
}