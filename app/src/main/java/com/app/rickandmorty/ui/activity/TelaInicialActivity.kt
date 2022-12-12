package com.app.rickandmorty.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.rickandmorty.ui.adapter.AdapterPersonagens
import com.app.rickandmorty.databinding.ActivityInicioBinding
import kotlinx.coroutines.launch


class TelaInicialActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInicioBinding.inflate(layoutInflater)
    }

    private var adapter: AdapterPersonagens? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listiners()
    }

    private fun listiners() {
        binding.apply {
            lifecycleScope.launch {
                val per = BuscarPersonagens.buscarUmaPagina()
                adapter = AdapterPersonagens(this@TelaInicialActivity, per)
                RecyclerInicio.adapter = adapter
                adapter?.itemClick = {
                    val intent = Intent(this@TelaInicialActivity, DetalhesActivity::class.java).apply {
                        putExtra("personagem", it)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}