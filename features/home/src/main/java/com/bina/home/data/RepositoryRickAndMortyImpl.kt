package com.bina.home.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.bina.home.data.datasource.RickAndMortyListCharacterDataSource
import com.bina.home.data.mapper.ListCharactersMapper
import com.bina.home.domain.model.ListCharacters
import com.bina.home.domain.repository.RepositoryRickAndMorty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepositoryRickAndMortyImpl(
    private val serviceDataSource: RickAndMortyListCharacterDataSource,
    private val listCharactersMapper: ListCharactersMapper
) : RepositoryRickAndMorty {
    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun getListCharacters(): Flow<ListCharacters> {
        return serviceDataSource.getListCharacters().map(listCharactersMapper::map)
    }
}