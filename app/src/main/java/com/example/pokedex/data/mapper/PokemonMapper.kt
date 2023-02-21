package com.example.pokedex.data.mapper

import com.example.pokedex.ui.models.Pokemon
import com.example.pokedex.data.network.resources.PokemonListResource

interface PokemonMapper {

    fun fromDomain(pokemonListResource: PokemonListResource) : Pokemon


    fun toDomain(pokemon: Pokemon) : PokemonListResource
}