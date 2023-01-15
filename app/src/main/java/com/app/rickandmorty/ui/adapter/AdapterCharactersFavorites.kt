package com.app.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardCharacterDataBinding
import com.app.rickandmorty.extras.loadImage
import com.app.rickandmorty.models.Character

class AdapterCharactersFavorites(
    private val characterList: List<Character>? = null,
    var onItemClickListener: (character: Character) -> Unit = {}
) : RecyclerView.Adapter<AdapterCharactersFavorites.ViewHolder>() {

    inner class ViewHolder(
        private val binding: CardCharacterDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindCharacterData(character: Character?) {
            character?.let {
                character.image?.let { binding.imgCharacterData.loadImage(it) }
                character.name?.let { binding.nameCharacterData.text = character.name }
                character.location.let { binding.locationCharacterData.text = character.location.name }
                character.status?.let { binding.statusCharacterData.text = character.status }
                binding.root.setOnClickListener { onItemClickListener(character) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CardCharacterDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        characterList?.get(position)?.let { holder.bindCharacterData(it) }
    }

    override fun getItemCount(): Int {
        return characterList?.let {
            return@let characterList.size
        } ?: 0
    }


}