package com.bina.home.data

import androidx.paging.PagingData
import com.bina.home.data.datasource.RickAndMortyListCharacterDataSource
import com.bina.home.data.model.ListCharactersModel
import com.bina.home.domain.repository.RepositoryRickAndMorty
import kotlinx.coroutines.flow.Flow

class RepositoryRickAndMortyImpl(
    private val dataSource: RickAndMortyListCharacterDataSource
) : RepositoryRickAndMorty {

    override fun getCharacters(query: String): Flow<PagingData<ListCharactersModel.Results>> {
        return dataSource.getCharacters(query)
    }
}