package com.bina.home.domain.useCase

import com.bina.home.domain.model.ListCharacters
import com.bina.home.domain.repository.RepositoryRickAndMorty
import kotlinx.coroutines.flow.Flow

class ListCharactersUseCase(
    private val repository: RepositoryRickAndMorty
) {
    suspend operator fun invoke(): Flow<ListCharacters> {
        return repository.getListCharacters()
    }
}