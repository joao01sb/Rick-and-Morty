package com.app.rickandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.entitys.FavoriteCharacterEntity
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface FavoriteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(character: FavoriteCharacterEntity)

    @Query("delete from favorite where id == :id")
    suspend fun delete(id: Int)

    @Query("select * from character where id == :id")
    suspend fun findFavoriteById(id: Int) : FavoriteCharacterEntity?

    @Query("select * from favorite")
    fun allFavorites() : Flow<List<FavoriteCharacterEntity>>

}