package com.app.rickandmorty.ui.activity

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.rickandmorty.databinding.ActivityDetalhesPersonagemBinding
import com.app.rickandmorty.extras.abrirNovaTela
import com.app.rickandmorty.extras.pegarImagemDoPersonagem
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.launch

class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesPersonagemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listiners()
        recuperarInformacoesPersonagem()
    }

    private fun listiners() {
        binding.apply {
//            iconeVoltarDetalhes.setOnClickListener { finish() }
            salvarPersonagem.setOnClickListener { TODO() }
        }
    }

    private fun recuperarInformacoesPersonagem() {
        val personagem = intent.getSerializableExtra("personagem") as Personagem?
        if (personagem != null) {
            lifecycleScope.launch {
                adicionandoInformacoesPersonagem(personagem)
            }
        } else {
            Toast.makeText(this, "Erro ao buscar informacoes do personagem", Toast.LENGTH_LONG)
        }
    }

    private fun adicionandoInformacoesPersonagem(personagem: Personagem) {
        binding.apply {
            personagem.image?.let { imagemPersonagem.pegarImagemDoPersonagem(it) }
            nome.text = personagem.name
            especie.text = personagem.species
            status.text = personagem.status
            genero.text = personagem.gender
            origem.text = personagem.origin?.name ?: " - "
        }
    }
}
