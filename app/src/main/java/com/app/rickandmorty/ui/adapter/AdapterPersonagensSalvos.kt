package com.app.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import com.app.rickandmorty.databinding.CardPersonagemBancoBinding
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem

class AdapterPersonagensSalvos(
    val listaDePersonagem: List<Personagem>? = null,
//    private val PersonagemClick: (Personagem, Navigator.Extras) -> Unit
) : RecyclerView.Adapter<AdapterPersonagensSalvos.ViewHolder>() {


    inner class ViewHolder(
        private val binding: CardPersonagemBancoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun vincularPersonagemComDados(personagem: Personagem) {
            personagem.image?.let { binding.imagemPersonagemBanco.pegarImagemDoPersonagem(it) }
            binding.nomePersonagemBanco.text = personagem.name
//            binding.root.setOnClickListener {
//                val extras = FragmentNavigator.Extras.Builder()
//                extras.addSharedElement(binding.imagemPersonagemBanco, "avatar")
//                personagem?.let{
//                    PersonagemClick(personagem!!,extras.build())
//                }
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CardPersonagemBancoBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listaDePersonagem?.get(position)?.let { holder.vincularPersonagemComDados(it) }
    }

    override fun getItemCount(): Int  = listaDePersonagem!!.size


}