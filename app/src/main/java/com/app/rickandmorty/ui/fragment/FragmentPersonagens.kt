package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.rickandmorty.databinding.FragmentPersonagensBinding
import com.app.rickandmorty.domain.viewModel.PersonagensViewModel
import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.ui.adapter.AdapterPersonagens
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentPersonagens : Fragment() {

    lateinit var binding: FragmentPersonagensBinding
    private val controleNav by lazy { findNavController() }
    private val personagensViewModel: PersonagensViewModel by viewModel()

    //    private val adapter = AdapterPersonagens {personagem, extras ->
//        var acao = FragmentPersonagensDirections.actionFragmentPersonagensToFragmentDetalhesPersonagem(personagem)
//        view?.let { it ->
//            Navigation.findNavController(it).let {
//                if (it.currentDestination?.id == R.id.fragment_personagens)
//                    it.navigate(acao, extras)
//            }
//        }
//    }
    private val adapter = AdapterPersonagens()
    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search()
        configuraRecyclerView()
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            personagensViewModel.fetchCharacters().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        binding.listaPersonagens.addItemDecoration(divisor)
        adapter.onItemClickListener = { personagemSelecionado ->
            detalhesPersonagem(personagemSelecionado)
        }
        binding.listaPersonagens.adapter = adapter
    }

    private fun detalhesPersonagem(personagem: Personagem) {
        val direcao = FragmentPersonagensDirections.actionFragmentPersonagensToFragmentDetalhesPersonagem(personagem)
        controleNav.navigate(direcao)
    }
}