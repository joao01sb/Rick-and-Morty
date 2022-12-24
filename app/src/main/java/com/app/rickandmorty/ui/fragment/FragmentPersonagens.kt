package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.databinding.FragmentPersonagensBinding
import com.app.rickandmorty.domain.viewModel.ListaDePersonagensViewModel
import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.ui.adapter.AdapterPersonagens
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentPersonagens : Fragment() {

    private lateinit var binding: FragmentPersonagensBinding
    private val personagensViewModel: ListaDePersonagensViewModel by viewModel()
    private val controladorNav by lazy { findNavController() }
    private var adapter =  AdapterPersonagens()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentPersonagensBinding.inflate(
           inflater,
           container,
           false
       )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search()
        configurarRecyclerView()
    }

    private var searchJob: Job? = null

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch { personagensViewModel.fetchCharacters().collectLatest { adapter.submitData(it) } }
    }

    private fun vaiParaDetalhesPersonagem(personagem: Personagem) {
        val direcao = FragmentPersonagensDirections.actionPersonagensParaDetalhes(personagem)
        controladorNav.navigate(direcao)
    }

    private fun configurarRecyclerView() {
        binding.apply {
            adapter.onItemClickListener = { vaiParaDetalhesPersonagem(it) }
            listaPersonagens.adapter = adapter
        }
    }

}