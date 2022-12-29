package com.app.rickandmorty.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.rickandmorty.models.Personagem

@Dao
interface PersonagemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun salvarPersonagem(personagem: Personagem)

    @Query("select * from Personagem")
     fun personagensFavoritos() : List<Personagem>
}