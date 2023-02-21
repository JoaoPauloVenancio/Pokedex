package com.example.pokedex.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemListBinding
import com.example.pokedex.ui.models.Pokemon

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.MovieViewHolder>() {

    private val pokemonList = ArrayList<Pokemon>()

    class MovieViewHolder(private val binding: PokemonItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Pokemon) {
            binding.txtPokemonName.text = ""
            binding.txtPokemonType.text = ""

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            PokemonItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int = pokemonList.size

    fun updateList(newList: List<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(newList)
        notifyDataSetChanged()
    }

}