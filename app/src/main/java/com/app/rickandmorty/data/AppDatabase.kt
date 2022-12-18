package com.app.rickandmorty.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.rickandmorty.data.converts.Convertes
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.models.Personagem

@Database(entities = [Personagem::class], version = 1, exportSchema = true)
@TypeConverters(Convertes::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun PersonagemAcoes(): PersonagemDAO

    companion object {
        fun instancia(context: Context): AppDataBase = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "rickapp.db"
        ).build()
    }

}