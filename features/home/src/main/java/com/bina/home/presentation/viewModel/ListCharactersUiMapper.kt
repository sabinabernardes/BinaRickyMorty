package com.bina.home.presentation.viewModel

import com.bina.home.domain.model.ListCharacters
import com.bina.home.presentation.ListCharactersUiModel

class ListCharactersUiMapper {
    fun map(domainModel: ListCharacters): List<ListCharactersUiModel> {
        return domainModel.responseApi.map {
            ListCharactersUiModel(
                id = it.id,
                name = it.name,
                status = it.status,
                image = it.image
            )
        }
    }
}
