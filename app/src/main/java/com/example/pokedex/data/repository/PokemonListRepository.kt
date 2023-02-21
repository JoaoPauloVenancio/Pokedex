package com.example.pokedex.data.repository

import com.example.pokedex.ui.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {

    suspend fun getPokemonList() : Flow<List<Pokemon>>
}