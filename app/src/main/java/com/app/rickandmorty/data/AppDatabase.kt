package com.app.rickandmorty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.data.dao.UsuarioDAO
import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.models.Usuario

//@Database(entities = [Personagem::class, Usuario::class], version = 1, exportSchema = true)
//
//abstract class AppDataBase : RoomDatabase() {
//
//    abstract fun buscarPersonagemFavorito(): PersonagemDAO
//    abstract fun buscarUser() : UsuarioDAO
//
//    companion object {
//        fun instancia(context: Context): AppDataBase = Room.databaseBuilder(
//            context,
//            AppDataBase::class.java,
//            "rickapp.db"
//        ).build()
//    }
//
//}