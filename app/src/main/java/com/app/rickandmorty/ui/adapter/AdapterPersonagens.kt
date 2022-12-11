package com.app.rickandmorty.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardCharacterBinding
import com.app.rickandmorty.databinding.CardPersonagemBinding
import com.app.rickandmorty.extras.abrirNovaTela
import com.app.rickandmorty.extras.listenClick
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.ui.activity.DetalhesActivity

class AdapterPersonagens(
    private val context: Context,
    val personagens: List<Personagem> = listOf()
) : RecyclerView.Adapter<AdapterPersonagens.ViewHolder>() {

    var itemClick: ((Personagem) -> Unit)?  = null

    inner class ViewHolder(
        private val binding: CardCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var visibilidade = View.GONE
        fun vincularPersonagemComDados(per: Personagem?) {
            if (per != null) {

                visibilidade = View.VISIBLE
                binding.apply {
                    imageCard.visibility = visibilidade
                    per.image?.let { imageCard.pegarImagemDoPersonagem(it) }
                    nomeCard.text = per.name
                    statusCard.text = per.status
                    origemCard.text = per.origin?.name ?: " - "
                }
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardCharacterBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = personagens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincularPersonagemComDados(personagens[position])
        holder.itemView.setOnClickListener {
            itemClick?.invoke(personagens[position])
        }
    }


}