package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.rickandmorty.databinding.FragmentCharactersBinding
import com.app.rickandmorty.domain.viewModel.CharactersViewModel
import com.app.rickandmorty.models.Character
import com.app.rickandmorty.ui.adapter.AdapterCharacters
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentCharacters : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val navController by lazy { findNavController() }
    private val charactersViewModel: CharactersViewModel by viewModel()
    private val adapter = AdapterCharacters()
    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerContainer.startLayoutAnimation()
        search()
        configRecyclerView()
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            delay(1000)
            charactersViewModel.fetchCharacters().collectLatest {
                withContext(Dispatchers.Main) {
                    binding.shimmerContainer.stopShimmer()
                    binding.shimmerContainer.visibility = GONE
                    binding.listCharacters.visibility = VISIBLE
                }
                adapter.submitData(it)
            }
        }
    }

    private fun configRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        binding.listCharacters.addItemDecoration(divisor)
        binding.listCharacters.adapter = adapter
        adapter.onItemClickListener = { goDetailsCharacter(it) }
    }

    private fun goDetailsCharacter(character: Character) {
        val direction = FragmentCharactersDirections.actionCharactersForCharacterDetails(character)
        navController.navigate(direction)
    }
}