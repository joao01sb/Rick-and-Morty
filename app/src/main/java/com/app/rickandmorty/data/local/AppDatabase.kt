package com.app.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.rickandmorty.data.local.converts.Convertes
import com.app.rickandmorty.data.local.dao.CharacterDAO
import com.app.rickandmorty.data.local.dao.FavoriteDAO
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.entitys.FavoriteCharacterEntity

@Database(entities = [CharacterEntity::class, FavoriteCharacterEntity::class], version = 1)
@TypeConverters(Convertes::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO
    abstract fun favoriteDAO(): FavoriteDAO
}