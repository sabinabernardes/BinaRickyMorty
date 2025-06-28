package com.bina.details.domain.usecase

import com.bina.details.data.response.CharacterDetailsResponse
import com.bina.details.domain.repository.DetailsRepository

class GetCharacterDetailsUseCase(
    private val repository: DetailsRepository
) {
    suspend operator fun invoke(id: Int): CharacterDetailsResponse? {
        return repository.getCharacterDetails(id)
    }
}

