package com.app.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardCharacterBinding
import com.app.rickandmorty.extras.loadImage
import com.app.rickandmorty.models.Character

class AdapterCharacters(
    var onItemClickListener: (character: Character) -> Unit = {}
) : PagingDataAdapter<Character, AdapterCharacters.ViewHolder>(CharacterDiff) {

    object CharacterDiff : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            newItem.id == oldItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            newItem == oldItem
    }

    inner class ViewHolder(
        private val binding: CardCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindCharacter(position: Int) {
            val character = getItem(position)
            character?.let {
                binding.apply {
                    character.image?.let { imgCharacter.loadImage(it) }
                    nameCharacter.text = character.name
                    root.setOnClickListener {
                        onItemClickListener(character)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        CardCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindCharacter(position)


}