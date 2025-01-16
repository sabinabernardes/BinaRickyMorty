package com.bina.binarickymorty.domain.repository

import com.bina.binarickymorty.domain.model.ListCharacters
import kotlinx.coroutines.flow.Flow

interface RepositoryRickAndMorty {
    suspend fun getListCharacters(): Flow<ListCharacters>
}