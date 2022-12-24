package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.app.rickandmorty.R
import com.app.rickandmorty.data.AppDataBase
import com.app.rickandmorty.databinding.FragmentDetalhesPersonagemBinding
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel2
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FragmentDetalhesPersonagem : Fragment() {

    private lateinit var binding: FragmentDetalhesPersonagemBinding
    private val argumentos by navArgs<FragmentDetalhesPersonagemArgs>()
    private val personagemEncontrado by lazy { argumentos.personagem }
    private val viewModelPersonagem: PersonagemViewModel by viewModel { parametersOf(personagemEncontrado) }

    private val controladorNav by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetalhesPersonagemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            nome.text = viewModelPersonagem.personagem.name ?: ""
            genero.text = viewModelPersonagem.personagem.gender ?: ""
            status.text = viewModelPersonagem.personagem.status ?: ""
            especie.text = viewModelPersonagem.personagem.species ?: ""
            origem.text = viewModelPersonagem.personagem.origin?.name ?: ""
            viewModelPersonagem.personagem.image?.let { imagemPersonagem.pegarImagemDoPersonagem(it) }
            salvarPersonagem.setOnClickListener {
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModelPersonagem.salvarPersonagemFavorito(personagemEncontrado)
                }
            }
        }
        voltarParaListaDePersonagens()
    }

    private fun voltarParaListaDePersonagens() {
        val direcao = FragmentDetalhesPersonagemDirections.actionDetalhesParaPersonagens()
        controladorNav.navigate(direcao)
    }
}