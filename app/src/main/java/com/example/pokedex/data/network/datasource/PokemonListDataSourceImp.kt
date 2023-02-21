package com.example.pokedex.data.network.datasource

import android.util.Log
import com.example.pokedex.data.network.resources.PokemonListResource
import com.example.pokedex.data.services.PokemonApi
import javax.inject.Inject

class PokemonListDataSourceImp @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonListDataSource {

    override suspend fun getPokemonList(): List<PokemonListResource> {
        val body = pokemonApi.getPokemonList()

        Log.d("debugg", body.toString())

        return body
    }
}