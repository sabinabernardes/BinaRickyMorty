package com.bina.home.data.mapper

import com.bina.home.data.model.ListCharactersModel
import com.bina.home.domain.model.ListCharacters
import com.bina.home.utils.Mapper

class ListCharactersMapper : Mapper<ListCharactersModel, ListCharacters> {
    override fun map(source: ListCharactersModel): ListCharacters {
        return ListCharacters(
            info = mapInfo(source.info),
            responseApi = mapResults(source.results)
        )
    }

    private fun mapInfo(info: ListCharactersModel.Info): ListCharacters.Info {
        return ListCharacters.Info(
            count = info.count,
            next = info.next,
            prev = info.prev,
            pages = info.pages
        )
    }

    private fun mapResults(results: List<ListCharactersModel.Results>): List<ListCharacters.Person> {
        return results.map {
            ListCharacters.Person(
                created = it.created,
                episode = it.episode,
                gender = it.gender,
                id = it.id,
                image = it.image,
                name = it.name,
                species = it.species,
                status = it.status,
                type = it.type,
                url = it.url,
                location = mapLocation(),
                origin = mapOrigin()
            )
        }
    }

    private fun mapLocation(): ListCharacters.Person.Location {
        return ListCharacters.Person.Location(
            name = "",
            url = ""
        )
    }

    private fun mapOrigin(): ListCharacters.Person.Origin {
        return ListCharacters.Person.Origin(
            name = "",
            url = ""
        )
    }
}
