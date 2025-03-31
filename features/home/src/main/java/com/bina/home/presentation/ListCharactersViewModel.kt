package com.bina.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bina.home.domain.useCase.ListCharactersUseCase
import com.bina.home.presentation.viewModel.ListCharactersUiMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ListCharactersViewModel(
    private val listCharactersUseCase: ListCharactersUseCase,
    private val listCharactersUiMapper: ListCharactersUiMapper,
    private val coroutinesDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _listCharactersUiModel = MutableStateFlow<List<ListCharactersUiModel>>(emptyList())
    val listCharactersUiModel: StateFlow<List<ListCharactersUiModel>> = _listCharactersUiModel

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: StateFlow<String?> = _error

    init {
        getListCharacters()
    }

    private fun getListCharacters() {
        viewModelScope.launch {
            listCharactersUseCase()
                .flowOn(coroutinesDispatcher)
                .catch { exception -> _error.value = exception.message }
                .collect { domainModel ->
                    _listCharactersUiModel.value = listCharactersUiMapper.map(domainModel)
                }
        }
    }

    fun clearError() {
        _error.value = null
    }

    fun onRetry() {
        getListCharacters()
    }
}

