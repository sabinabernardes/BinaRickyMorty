package com.bina.binarickymorty.presentation.viewModel

import com.bina.binarickymorty.domain.model.ListCharacters
import com.bina.binarickymorty.presentation.ListCharactersUiModel

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
