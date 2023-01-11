package com.app.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.databinding.FragmentCadastroBinding

class FragmentCadastro : Fragment() {

   lateinit var binding: FragmentCadastroBinding
   val controler by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cadastroUsuarioBotaoCadastrar.setOnClickListener { irParaLogin() }
    }

    fun irParaLogin() {
        val direcao = FragmentCadastroDirections.actionFragmentCadastroToFragmentLogin()
        controler.navigate(direcao)
    }

}