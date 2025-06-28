package com.bina.details.domain.mapper

import com.bina.details.data.response.CharacterDetailsResponse
import com.bina.details.domain.model.CharacterDetails

fun CharacterDetailsResponse.toDomain(): CharacterDetails = CharacterDetails(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin?.let {
        CharacterDetails.Origin(
            name = it.name,
            url = it.url
        )
    },
    location = location?.let {
        CharacterDetails.Location(
            name = it.name,
            url = it.url
        )
    },
    image = image,
    episode = episode,
    url = url,
    created = created
)

