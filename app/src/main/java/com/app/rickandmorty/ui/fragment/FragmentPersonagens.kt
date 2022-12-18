package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.FragmentDetalhesPersonagemBinding
import com.app.rickandmorty.databinding.FragmentPersonagensBinding
import com.app.rickandmorty.domain.viewModel.ListaDePersonagensViewModel
import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.ui.adapter.AdapterPersonagens
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel




class FragmentPersonagens : Fragment() {

    lateinit var binding: FragmentPersonagensBinding
    private val personagensViewModel: ListaDePersonagensViewModel by viewModel()
    private val adapter = AdapterPersonagens {personagem, extras ->
        var acao = FragmentPersonagensDirections.actionFragmentPersonagensToFragmentDetalhesPersonagem(personagem)
        view?.let { it ->
            Navigation.findNavController(it).let {
                if (it.currentDestination?.id == R.id.fragment_personagens)
                    it.navigate(acao, extras)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        binding.listaPersonagens.adapter = adapter
        search()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPersonagens().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private var searchJob: Job? = null

    private fun search() {

        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            personagensViewModel.fetchCharacters().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}