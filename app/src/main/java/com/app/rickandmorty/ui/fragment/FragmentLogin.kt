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
import com.firebase.ui.auth.AuthUI

class FragmentLogin : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val controler by lazy { findNavController() }
    private val RC_SIGN_IN = 1

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
        // pego a instancia do firebaseUI
        val authUi = AuthUI.getInstance()
        //intent responsavel por abrir as telas do fluxo do fireUI
        val intent = authUi.createSignInIntentBuilder()
            .setAvailableProviders(listOf(AuthUI.IdpConfig.EmailBuilder().build()))
            .build()
        // para lidar com o retorno da activiy aberta
        startActivityForResult(intent, RC_SIGN_IN)
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