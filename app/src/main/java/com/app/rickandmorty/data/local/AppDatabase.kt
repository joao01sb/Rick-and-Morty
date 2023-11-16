package com.app.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.rickandmorty.data.local.converts.Convertes
import com.app.rickandmorty.data.local.dao.CharcterDAO
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.domain.models.Character

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = true)
@TypeConverters(Convertes::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun charactersActionData(): CharcterDAO
}