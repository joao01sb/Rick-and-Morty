package com.app.rickandmorty.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.rickandmorty.models.Character

@Dao
interface CharcterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveCharacter(character: Character)

    @Query("select * from Character")
     fun searchFavoritesCharacters() : List<Character>?
}