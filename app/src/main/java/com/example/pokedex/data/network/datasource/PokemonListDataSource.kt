package com.example.pokedex.data.network.datasource

import com.example.pokedex.data.network.resources.PokemonListResource

interface PokemonListDataSource {

   suspend fun getPokemonList() : List<PokemonListResource>
}