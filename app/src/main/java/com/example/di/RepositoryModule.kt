package com.example.di

import com.example.Constants
import com.example.Constants.BASE_URL
import com.example.pokedex.BuildConfig
import com.example.pokedex.data.mapper.PokemonMapper
import com.example.pokedex.data.mapper.PokemonMapperImpl
import com.example.pokedex.data.network.datasource.PokemonListDataSource
import com.example.pokedex.data.network.datasource.PokemonListDataSourceImp
import com.example.pokedex.data.repository.PokemonListRepository
import com.example.pokedex.data.repository.PokemonListRepositoryImp
import com.example.pokedex.data.services.PokemonApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindPokemonListRepository(pokemonListRepositoryImp: PokemonListRepositoryImp): PokemonListRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindPokemonListDataSource(pokemonListDataSourceImp: PokemonListDataSourceImp): PokemonListDataSource
}

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Singleton
    @Binds
    abstract fun bindPokemonMapper(pokemonMapper: PokemonMapperImpl): PokemonMapper
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideRetrofit(): PokemonApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher