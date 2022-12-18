package com.app.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardPersonagemBinding
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem

class AdapterPersonagens(
    private val PersonagemClick: (Personagem, Navigator.Extras) -> Unit
) : PagingDataAdapter<Personagem, AdapterPersonagens.ViewHolder>(PersonagemDiff) {

    object PersonagemDiff : DiffUtil.ItemCallback<Personagem>() {
        override fun areItemsTheSame(oldItem: Personagem, newItem: Personagem): Boolean =
            newItem.id == oldItem.id

        override fun areContentsTheSame(oldItem: Personagem, newItem: Personagem): Boolean =
            newItem == oldItem
    }

    inner class ViewHolder(
        private val binding: CardPersonagemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun vincularPersonagemComDados(position: Int) {
            var personagem = getItem(position)
            if (personagem != null) {
                binding.apply {
                    personagem!!.image?.let { imagemPersonagemBanco.pegarImagemDoPersonagem(it) }
                    nomePersonagemBanco.text = personagem!!.name
                    statusCard.text = personagem!!.status
                    binding.root.setOnClickListener {
                        val extras = FragmentNavigator.Extras.Builder()
                        extras.addSharedElement(binding.imagemPersonagemBanco, "avatar")
                        personagem?.let{
                            PersonagemClick(personagem!!,extras.build())
                        }
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(CardPersonagemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.vincularPersonagemComDados(position)


}