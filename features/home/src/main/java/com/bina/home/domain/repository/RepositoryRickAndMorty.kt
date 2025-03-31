package com.bina.home.domain.repository

import com.bina.home.domain.model.ListCharacters
import kotlinx.coroutines.flow.Flow

interface RepositoryRickAndMorty {
    suspend fun getListCharacters(): Flow<ListCharacters>
}