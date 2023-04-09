package com.app.rickandmorty.ui.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.opengl.Visibility
import android.os.Build
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
        if (isNetworkConnected(requireContext())) {
            binding.listCharactersNotNetwork.visibility = View.GONE
            binding.listCharacters.visibility = VISIBLE
            search()
            configRecyclerView()
        } else {
            binding.listCharactersNotNetwork.visibility = VISIBLE
        }
    }

    fun isNetworkConnected(context: Context): Boolean {
        // Obtém a instância do ConnectivityManager
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Verifica se a versão do Android é igual ou superior à 23 (Marshmallow)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Obtém a rede ativa
            val activeNetwork = connectivityManager.activeNetwork ?: return false

            // Obtém as capacidades da rede ativa
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

            // Verifica se a rede tem capacidade para acessar a internet
            return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            // Para as versões mais antigas do Android, verifica se há alguma rede ativa
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected
        }
    }

    private fun search() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            charactersViewModel.fetchCharacters().collectLatest {
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