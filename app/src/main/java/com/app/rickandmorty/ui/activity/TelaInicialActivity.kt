package com.app.rickandmorty.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.ActivityTelaInicialBinding
import com.app.rickandmorty.ui.fragment.*


class TelaInicialActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    private val controle by lazy {
        findNavController(R.id.fragmentContainerView)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
        listiner()
    }

    fun listiner() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_personagens -> controle.navigate(R.id.fragment_personagens)
                R.id.fragmentFavoritos -> controle.navigate(R.id.fragmentFavoritos)
                R.id.sobre -> controle.navigate(R.id.fragment_sobre)
            }
            return@setOnItemSelectedListener true
        }
    }

}