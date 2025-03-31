import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.bina.home.data.model.ListCharactersModel
import com.bina.home.domain.useCase.GetCharactersUseCase
import com.bina.home.presentation.CharactersUiState
import com.bina.home.presentation.ListCharactersUiModel
import com.bina.home.presentation.viewModel.ListCharactersUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ListCharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val uiMapper: ListCharactersUiMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val uiState: StateFlow<CharactersUiState> = _uiState

    private var currentQuery = ""

    fun getCharacters(query: String = "") {
        currentQuery = query
        viewModelScope.launch {
            getCharactersUseCase(query)
                .map { pagingData: PagingData<ListCharactersModel.Results> ->
                    pagingData.map { result: ListCharactersModel.Results ->
                        uiMapper.map(result)
                    }
                }
                .cachedIn(viewModelScope)
                .onStart {
                    _uiState.value = CharactersUiState.Loading
                }
                .catch { e ->
                    _uiState.value = CharactersUiState.Error(e.message)
                }
                .collect { mappedPagingData: PagingData<ListCharactersUiModel> ->
                    _uiState.value = CharactersUiState.Success(flowOf(mappedPagingData))
                }
        }
    }

    fun onRetry() {
        getCharacters(currentQuery)
    }

    fun clearError() {
        if (_uiState.value is CharactersUiState.Error) {
            _uiState.value = CharactersUiState.Loading
        }
    }
}
