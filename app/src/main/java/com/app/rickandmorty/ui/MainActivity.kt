package com.app.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }
    private val navController by lazy {
        findNavController(R.id.fragmentContainerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
        actionListiner()
    }

    private fun actionListiner() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_personagens -> navController.navigate(R.id.fragment_personagens)
                R.id.fragmentFavoritos -> navController.navigate(R.id.fragmentFavoritos)
                R.id.sobre -> navController.navigate(R.id.fragment_sobre)
            }
            return@setOnItemSelectedListener true
        }
    }

}