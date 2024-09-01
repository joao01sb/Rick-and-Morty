package com.app.rickandmorty.data.local.converts

import androidx.room.TypeConverter
import com.app.rickandmorty.domain.models.CharacterLocation
import com.app.rickandmorty.domain.models.Episode
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.util.Date

class Convertes {

    val json: Json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    @TypeConverter
    fun appToString(origin: CharacterLocation): String {
        return json.encodeToString(origin)
    }
    @TypeConverter
    fun stringToApp(origin: String): CharacterLocation {
        return json.decodeFromString<CharacterLocation>(origin)
    }

    @TypeConverter
    fun listEpisodesToString(episode: List<String>) : String {
        return json.encodeToString(episode)
    }

    @TypeConverter
    fun stringToEpisodesList(episodes: String) : List<String> {
       return json.decodeFromString<List<String>>(episodes)
    }

    @TypeConverter
    fun fromDate(value: Long?): Date? = if (value == null) null else Date(value)
    @TypeConverter
    fun dateToLong(date: Date?): Long? = date?.time


 }