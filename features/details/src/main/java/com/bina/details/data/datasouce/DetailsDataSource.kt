package com.bina.details.data.datasouce

import com.bina.details.data.response.CharacterDetailsResponse


interface DetailsDataSource {
    suspend fun getCharacterDetails(id: Int): CharacterDetailsResponse?
}
