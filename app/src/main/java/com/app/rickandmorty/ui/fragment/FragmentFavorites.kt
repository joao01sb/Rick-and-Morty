package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.databinding.FragmentFavoritesBinding
import com.app.rickandmorty.domain.viewModel.CharactersViewModel
import com.app.rickandmorty.models.Character
import com.app.rickandmorty.ui.adapter.AdapterCharactersFavorites
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentFavorites : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val navController by lazy {
        findNavController()
    }
    private val charactersViewModel: CharactersViewModel by viewModel()
    private lateinit var adapter: AdapterCharactersFavorites

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            val characters = charactersViewModel.searchFavoritesCharacters()
            characters?.let {
                adapter = AdapterCharactersFavorites(characters)
                withContext(Dispatchers.Main) {
                    binding.personagensSalvos.adapter = adapter
                }
            } ?: TODO("implementar uma função para mostrar nenhum personagem encontrado")
        }
        adapter.onItemClickListener = { goDetailsCharacter(it) }
    }

    private fun goDetailsCharacter(character: Character) {
        val direction = FragmentFavoritesDirections.actionFragmentFavoritosToFragmentDetalhesPersonagem(character)
        navController.navigate(direction)
    }

}