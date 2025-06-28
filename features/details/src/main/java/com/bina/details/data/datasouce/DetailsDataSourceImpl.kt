package com.bina.details.data.datasouce

import com.bina.details.data.api.DetailsApi
import com.bina.details.data.response.CharacterDetailsResponse

class DetailsDataSourceImpl(private val api: DetailsApi) : DetailsDataSource {
    override suspend fun getCharacterDetails(id: Int): CharacterDetailsResponse? {
        val response = api.getCharacterDetails(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
