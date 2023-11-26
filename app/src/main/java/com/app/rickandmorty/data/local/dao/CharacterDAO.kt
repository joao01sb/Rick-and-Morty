package com.app.rickandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.domain.models.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Upsert
    suspend fun upSertAll(characters: List<CharacterEntity>)

    @Query("SELECT * FROM character")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("Delete from character")
    suspend fun clearAll()

    @Query("select * from character where id == :id")
    suspend fun findCharacterById(id: String) : Character?
}