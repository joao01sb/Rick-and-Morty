package com.app.rickandmorty.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.rickandmorty.models.Personagem

@Dao
interface PersonagemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun salvarPersonagem(vararg personagem: Personagem)

    @Query("select * from Personagem")
     fun personagensFavoritos() : List<Personagem>
}