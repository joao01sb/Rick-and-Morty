package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.FragmentFavoritosBinding
import com.app.rickandmorty.databinding.FragmentSobreBinding

class FragmentSobre : Fragment() {

    private lateinit var binding: FragmentSobreBinding
    private val controler by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSobreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sairLogin.setOnClickListener { irParaLogin() }
    }

    fun irParaLogin() {
        val direcao = FragmentSobreDirections.actionFragmentSobreToFragmentLogin()
        controler.navigate(direcao)
    }
}