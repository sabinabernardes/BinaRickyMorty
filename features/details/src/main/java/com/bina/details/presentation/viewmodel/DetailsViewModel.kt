package com.bina.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bina.details.domain.mapper.toDomain
import com.bina.details.domain.model.CharacterDetails
import com.bina.details.domain.usecase.GetCharacterDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    val characterDetailsUiMapper: com.bina.details.presentation.mapper.CharacterDetailsUiMapper
) : ViewModel() {

    private val _characterDetails = MutableStateFlow<CharacterDetails?>(null)
    val characterDetails: StateFlow<CharacterDetails?> = _characterDetails

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchCharacterDetails(1)
    }

    fun fetchCharacterDetails(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val details = getCharacterDetailsUseCase(id)?.toDomain()
                _characterDetails.value = details
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
