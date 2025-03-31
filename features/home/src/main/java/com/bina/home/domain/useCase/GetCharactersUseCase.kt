package com.bina.home.domain.useCase

import androidx.paging.PagingData
import com.bina.home.data.model.ListCharactersModel
import com.bina.home.domain.repository.RepositoryRickAndMorty
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val repository: RepositoryRickAndMorty
) {
    operator fun invoke(query: String): Flow<PagingData<ListCharactersModel.Results>> {
        return repository.getCharacters(query)
    }
}