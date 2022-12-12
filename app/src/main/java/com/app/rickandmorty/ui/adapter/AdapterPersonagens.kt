package com.app.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardCharacterBinding
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem

class AdapterPersonagens(
    val personagens: List<Personagem> = listOf()
) : PagingDataAdapter<Personagem, AdapterPersonagens.ViewHolder>(PersonagemDiff) {

    var itemClick: ((Personagem, Any) -> Unit)?  = null

    object PersonagemDiff : DiffUtil.ItemCallback<Personagem>() {
        override fun areItemsTheSame(oldItem: Personagem, newItem: Personagem): Boolean =
            newItem.id == oldItem.id

        override fun areContentsTheSame(oldItem: Personagem, newItem: Personagem): Boolean =
            newItem == oldItem
    }

    private var personagem: Personagem? = null

    inner class ViewHolder(
        private val binding: CardCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun vincularPersonagemComDados(position: Int) {
            personagem = getItem(position)
            if (personagem != null) {
                binding.apply {
                    personagem!!.image?.let { imagemCard.pegarImagemDoPersonagem(it) }
                    nomeCard.text = personagem!!.name
                    statusCard.text = personagem!!.status
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = personagens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincularPersonagemComDados(position)
        holder.itemView.setOnClickListener {
            personagem?.let { it1 -> itemClick?.invoke(it1, 1) }
        }
    }


}