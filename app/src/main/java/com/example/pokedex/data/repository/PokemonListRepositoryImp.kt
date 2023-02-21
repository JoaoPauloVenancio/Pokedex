package com.example.pokedex.data.repository

import android.util.Log
import com.example.di.IoDispatcher
import com.example.pokedex.data.mapper.PokemonMapper
import com.example.pokedex.data.network.datasource.PokemonListDataSource
import com.example.pokedex.ui.models.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokemonListRepositoryImp @Inject constructor(
    private val pokemonListDataSource: PokemonListDataSource,
    private val pokemonMapper: PokemonMapper,
    @IoDispatcher private val dispatcherIo: CoroutineDispatcher
) : PokemonListRepository {

    override suspend fun getPokemonList(): Flow<List<Pokemon>> = flow {
        val pokemonListResponse = pokemonListDataSource.getPokemonList()
        Log.d("kkkkkkkkkk", pokemonListResponse.toString())
        val map = pokemonListResponse.map {
            pokemonMapper.fromDomain(it)
        }
        emit(map)
    }.flowOn(dispatcherIo)
}