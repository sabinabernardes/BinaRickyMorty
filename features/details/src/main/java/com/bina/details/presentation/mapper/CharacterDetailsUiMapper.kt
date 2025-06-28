package com.bina.details.presentation.mapper

import com.bina.details.domain.model.CharacterDetails
import com.bina.details.presentation.model.CharacterDetailsUiModel

class CharacterDetailsUiMapper {
    fun map(domain: CharacterDetails): CharacterDetailsUiModel = CharacterDetailsUiModel(
        id = domain.id,
        name = domain.name,
        status = domain.status,
        species = domain.species,
        type = domain.type,
        gender = domain.gender,
        originName = domain.origin?.name,
        locationName = domain.location?.name,
        image = domain.image,
        episodeCount = domain.episode?.size,
        url = domain.url,
        created = domain.created
    )
}
