package com.app.rickandmorty.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.rickandmorty.databinding.ActivityLoginBinding
import com.app.rickandmorty.extras.abrirNovaTela

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(binding.root)
        listiners()
    }

    private fun listiners() {
        binding.apply {
            botaoLogin.setOnClickListener {
//                abrirNovaTela(ActivityBuscarPersonagens::class.java) }
                botaoCadastrar.setOnClickListener {
//                abrirNovaTela(ActivityCadastroUser::class.java) }
                }
            }

        }

    }

}