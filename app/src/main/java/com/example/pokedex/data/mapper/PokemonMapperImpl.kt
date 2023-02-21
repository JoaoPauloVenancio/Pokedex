package com.example.pokedex.data.mapper

import com.example.pokedex.data.network.resources.PokemonListResource
import com.example.pokedex.data.network.resources.PokemonResultTypeResource
import com.example.pokedex.ui.models.Pokemon
import com.example.pokedex.ui.models.PokemonResultType
import javax.inject.Inject

class PokemonMapperImpl @Inject constructor(): PokemonMapper  {

    override fun fromDomain(pokemonListResource: PokemonListResource): Pokemon {
        return Pokemon(
            count = pokemonListResource.count.toString(),
            next = pokemonListResource.next,
            previous = pokemonListResource.previous,
            results = pokemonListResource.results.map {
                it.toPokemonResultType()
            }
        )
    }

    override fun toDomain (pokemon: Pokemon): PokemonListResource {
        return PokemonListResource(
            count = pokemon.count.toInt(),
            next = pokemon.next,
            previous = pokemon.previous,
            results = pokemon.results.map {
                it.toPokemonResultTypeResource()
            }

        )
    }

    private fun PokemonResultTypeResource.toPokemonResultType() = PokemonResultType(
        name = this.name,
        url = this.url
    )

    private fun PokemonResultType.toPokemonResultTypeResource() = PokemonResultTypeResource(
        name = this.name,
        url = this.url
    )
}