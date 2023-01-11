package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.FragmentFavoritosBinding
import com.app.rickandmorty.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val controler by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBotaoLogar.setOnClickListener { irParaPersonagens() }
        binding.loginBotaoCadastrarUsuario.setOnClickListener { irParaCadastro() }
    }

    fun irParaPersonagens() {
        val direcao = FragmentLoginDirections.actionFragmentLoginToFragmentPersonagens()
        controler.navigate(direcao)
    }

    fun irParaCadastro() {
        val direcao = FragmentLoginDirections.actionFragmentLoginToFragmentCadastro()
        controler.navigate(direcao)
    }
}