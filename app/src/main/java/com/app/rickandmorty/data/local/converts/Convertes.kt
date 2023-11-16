package com.app.rickandmorty.data.local.converts

import androidx.room.TypeConverter
import com.app.rickandmorty.domain.models.CharacterLocation
import com.app.rickandmorty.domain.models.Episode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class Convertes {

    @TypeConverter
    fun appToString(origin: CharacterLocation): String = Gson().toJson(origin)
    @TypeConverter
    fun stringToApp(origin: String): CharacterLocation = Gson().fromJson(origin, CharacterLocation::class.java)

    @TypeConverter
    fun listEpisodesToString(episode: List<String>) : String = Gson().toJson(episode)
    @TypeConverter
    fun stringToEpisodesList(episodes: String) : List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(episodes, listType)
    }
 }