package com.app.rickandmorty.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.rickandmorty.data.converts.Convertes
import com.app.rickandmorty.data.dao.CharcterDAO
import com.app.rickandmorty.models.Character

@Database(entities = [Character::class], version = 1, exportSchema = true)
@TypeConverters(Convertes::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun charactersActionData(): CharcterDAO
}