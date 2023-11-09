package com.app.rickandmorty.data.converts

import androidx.room.TypeConverter
import com.app.rickandmorty.domain.models.CharacterLocation
import com.app.rickandmorty.domain.models.Episode
import com.google.gson.Gson
import org.json.JSONObject

class Convertes {

    @TypeConverter
    fun appToString(origin: CharacterLocation): String = Gson().toJson(origin)
    @TypeConverter
    fun stringToApp(origin: String): CharacterLocation = Gson().fromJson(origin, CharacterLocation::class.java)

    @TypeConverter
    fun listEpisodesToString(episode: Array<String>) : String = Gson().toJson(episode)
    @TypeConverter
    fun stringToEpisodesList(episode: String) : Array<String> = Gson().fromJson(episode, Array<String>::class.java)
 }