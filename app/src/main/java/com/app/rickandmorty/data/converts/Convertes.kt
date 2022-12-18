package com.app.rickandmorty.data.converts

import androidx.room.TypeConverter
import com.app.rickandmorty.models.CharacterLocation
import com.google.gson.Gson
import org.json.JSONObject

class Convertes {


    @TypeConverter
    fun appToString(origem: CharacterLocation): String = Gson().toJson(origem)

    @TypeConverter
    fun stringToApp(origem: String): CharacterLocation = Gson().fromJson(origem, CharacterLocation::class.java)
 }