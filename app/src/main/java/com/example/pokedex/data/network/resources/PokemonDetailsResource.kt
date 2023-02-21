package com.example.pokedex.data.network.resources

data class PokemonDetailsResource(
    val id : Int,
    val name : String,
    val type : PokemonTypeResource
)
