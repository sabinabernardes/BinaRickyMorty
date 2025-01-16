package com.bina.binarickymorty.domain.useCase

import com.bina.binarickymorty.domain.repository.RepositoryRickAndMorty
import com.bina.binarickymorty.domain.model.ListCharacters
import kotlinx.coroutines.flow.Flow

class ListCharactersUseCase(
    private val repository: RepositoryRickAndMorty
) {
    suspend operator fun invoke(): Flow<ListCharacters> {
        return repository.getListCharacters()
    }
}