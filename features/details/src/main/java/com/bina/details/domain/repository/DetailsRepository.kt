package com.bina.details.domain.repository

import com.bina.details.data.response.CharacterDetailsResponse

interface DetailsRepository {
    suspend fun getCharacterDetails(id: Int): CharacterDetailsResponse?
}
