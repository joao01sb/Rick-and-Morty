package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

    private val args: FragmentDetalhesPersonagemArgs by navArgs()
    private var binding: FragmentDetalhesPersonagemBinding? = null
    private val personagemViewModel: PersonagemViewModel by viewModel { parametersOf(args.personagem) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesPersonagemBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            nome.text = personagemViewModel.personagem?.name ?: ""
            genero.text = personagemViewModel.personagem?.gender ?: ""
            status.text = personagemViewModel.personagem?.status ?: ""
            especie.text = personagemViewModel.personagem?.species ?: ""
            origem.text = personagemViewModel.personagem?.origin?.name ?: ""
            personagemViewModel.personagem?.image?.let { imagemPersonagem.pegarImagemDoPersonagem(it) }
            salvarPersonagem.setOnClickListener {
                try {
                    lifecycleScope.launch(Dispatchers.IO) {
                        personagemViewModel.salvarPersonagem(args.personagem)
                    }
                    Toast.makeText(requireContext(), "Personagem Salvo com sucesso!", Toast.LENGTH_SHORT)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Personagem já esta salvo!", Toast.LENGTH_SHORT)
                }
            }
        }
    }
}