package com.bina.home.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bina.home.data.CharactersPagingSource
import com.bina.home.data.api.CharactersApi
import com.bina.home.data.model.ListCharactersModel
import kotlinx.coroutines.flow.Flow

class RickAndMortyListCharacterDataSourceImpl(
    private val apiService: CharactersApi
) : RickAndMortyListCharacterDataSource {

    override fun getCharacters(query: String): Flow<PagingData<ListCharactersModel.Results>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharactersPagingSource(apiService, query)
            }
        ).flow
    }
}
