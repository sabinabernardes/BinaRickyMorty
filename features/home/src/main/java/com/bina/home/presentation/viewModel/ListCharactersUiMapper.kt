package com.bina.home.presentation.viewModel

import com.bina.home.data.model.ListCharactersModel
import com.bina.home.presentation.ListCharactersUiModel

class ListCharactersUiMapper {
    fun map(result: ListCharactersModel.Results): ListCharactersUiModel {
        return ListCharactersUiModel(
            id = result.id,
            name = result.name,
            imageUrl = result.image
        )
    }
}
