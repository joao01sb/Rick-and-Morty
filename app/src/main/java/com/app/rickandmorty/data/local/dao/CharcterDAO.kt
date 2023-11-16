package com.app.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.app.rickandmorty.data.local.entitys.CharacterEntity

@Dao
interface CharcterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun saveCharacter(character: CharacterEntity)

     @Upsert
     suspend fun upSertAll(characters: List<CharacterEntity>)

     @Query("Delete from character")
     suspend fun clearAll()

    @Query("select * from character")
     suspend fun searchFavoritesCharacters() : List<CharacterEntity>?
}