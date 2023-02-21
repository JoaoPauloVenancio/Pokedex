package com.example.pokedex.data.services

import com.example.pokedex.data.network.resources.PokemonDetailsResource
import com.example.pokedex.data.network.resources.PokemonListResource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 151): List<PokemonListResource>

    @GET("pokemon/{id}")
    fun getPokemonDetails(id: Int): Response<List<PokemonDetailsResource>>
}