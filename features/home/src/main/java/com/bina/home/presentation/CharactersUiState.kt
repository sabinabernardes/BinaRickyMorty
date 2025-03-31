package com.bina.home.presentation

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

sealed class CharactersUiState {
    object Loading : CharactersUiState()
    data class Success(val data: Flow<PagingData<ListCharactersUiModel>>) : CharactersUiState()
    data class Error(val message: String?) : CharactersUiState()
}
