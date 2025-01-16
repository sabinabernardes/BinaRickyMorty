package com.bina.binarickymorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bina.binarickymorty.domain.model.ListCharacters
import com.bina.binarickymorty.domain.useCase.ListCharactersUseCase
import com.bina.binarickymorty.presentation.viewModel.ListCharactersUiMapper
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

    private val _listCharactersUiModel: MutableStateFlow<List<ListCharactersUiModel>?> = MutableStateFlow(null)
    val listCharactersUiModel: StateFlow<List<ListCharactersUiModel>?> = _listCharactersUiModel

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
                    _listCharactersUiModel.value = domainModel.let {
                        listCharactersUiMapper.map(it)
                    }
                }
        }
    }
}
