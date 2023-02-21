package com.example.pokedex.ui.models

data class Pokemon (
    val count : String,
    val next : String?,
    val previous : String?,
    val results : List<PokemonResultType>
)

