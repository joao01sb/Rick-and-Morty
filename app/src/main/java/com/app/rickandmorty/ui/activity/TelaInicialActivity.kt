package com.app.rickandmorty.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.ActivityTelaInicialBinding
import com.app.rickandmorty.ui.fragment.FragmentFavoritos
import com.app.rickandmorty.ui.fragment.FragmentPersonagens


class TelaInicialActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val navController = navHostFragment.navController
        listiner()
    }

    fun listiner() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.inicio -> {
                    replaceFragment(FragmentPersonagens())
                }
                R.id.favoritos -> {
                    replaceFragment(FragmentFavoritos())
                }
//                R.id.pesquisar -> {
//
//                }
                else -> {
                    TODO()
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val managerFragment = supportFragmentManager.beginTransaction()
        managerFragment.replace(R.id.fragmentContainerView, fragment).commit()
    }

}