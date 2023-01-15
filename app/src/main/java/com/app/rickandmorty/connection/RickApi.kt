package com.app.rickandmorty.connection

import com.app.rickandmorty.models.Character
import com.app.rickandmorty.models.RespList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface RickApi {

    @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
    @GET
    suspend fun searchCharacter(@Url url: String): Response<Character?>

    @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
    @GET("character")
    suspend fun searchCharactersByPag(@Query("page") page: Int? = null): RespList<Character>
}