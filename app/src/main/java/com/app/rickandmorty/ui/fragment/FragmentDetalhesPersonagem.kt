package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
    private val crudPersonagem: PersonagemViewModel2 by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesPersonagemBinding.inflate(inflater, container, false).apply {
            nome.text = personagemViewModel.personagem?.name ?: ""
            genero.text = personagemViewModel.personagem?.gender ?: ""
            status.text = personagemViewModel.personagem?.status ?: ""
            especie.text = personagemViewModel.personagem?.species ?: ""
            origem.text = personagemViewModel.personagem?.origin?.name ?: ""
            personagemViewModel.personagem?.image?.let { imagemPersonagem.pegarImagemDoPersonagem(it) }
            salvarPersonagem?.setOnClickListener {
                lifecycleScope.launch(Dispatchers.IO) {
                    personagemViewModel.personagem?.let { it1 -> crudPersonagem.salvar(it1) }
                }
            }
        }
        context?.let {
            sharedElementEnterTransition =
                TransitionInflater.from(it).inflateTransition(android.R.transition.move)
        }
        return binding!!.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentDetalhesPersonagem.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentDetalhesPersonagem().apply {
                arguments = Bundle().apply {}
            }
    }
}