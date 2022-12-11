package com.app.rickandmorty.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.rickandmorty.models.Personagem

interface PersonagemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salvarPersonagem(vararg personagem: Personagem)

    @Query("select * from Personagem")
    suspend fun personagensFavoritos() : List<Personagem>
}