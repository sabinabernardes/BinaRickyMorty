package com.bina.details.data.repository

import com.bina.details.data.datasouce.DetailsDataSource
import com.bina.details.data.response.CharacterDetailsResponse
import com.bina.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val detailsDataSource: DetailsDataSource
) : DetailsRepository {
    override suspend fun getCharacterDetails(id: Int): CharacterDetailsResponse? {
        return detailsDataSource.getCharacterDetails(id)
    }
}

