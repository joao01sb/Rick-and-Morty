package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.databinding.FragmentFavoritosBinding
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel2
import com.app.rickandmorty.ui.adapter.AdapterPersonagensSalvos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentFavoritos : Fragment() {

    lateinit var binding: FragmentFavoritosBinding
    private val personagemViewModel: PersonagemViewModel2 by viewModel()
    private val controladorNav by lazy {
        findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        lifecycleScope.launch(Dispatchers.IO) {
            val adapter = AdapterPersonagensSalvos(personagemViewModel.buscarPersonagensSalvos())
            withContext(Dispatchers.Main) {
                binding.personagensSalvos.adapter = adapter
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentFavoritos().apply {
                arguments = Bundle().apply {
                }
            }
    }
}