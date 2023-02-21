package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repository.PokemonListRepository
import com.example.pokedex.ui.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LatestPokemonUiState.Success(emptyList()))
    val uiState: StateFlow<LatestPokemonUiState> = _uiState

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            pokemonListRepository.getPokemonList().collect {
                _uiState.value = LatestPokemonUiState.Success(it)
            }
        }
    }

}

sealed class LatestPokemonUiState {
    data class Success(val pokemonList: List<Pokemon>) : LatestPokemonUiState()
    data class Error(val exception: Throwable) : LatestPokemonUiState()
}
