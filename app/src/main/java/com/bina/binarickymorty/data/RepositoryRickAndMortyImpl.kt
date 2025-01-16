package com.bina.binarickymorty.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.bina.binarickymorty.data.datasource.RickAndMortyListCharacterDataSource
import com.bina.binarickymorty.data.mapper.ListCharactersMapper
import com.bina.binarickymorty.domain.model.ListCharacters
import com.bina.binarickymorty.domain.repository.RepositoryRickAndMorty
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