package com.app.rickandmorty.connection.endpt

import com.app.rickandmorty.models.Personagem
import com.app.rickandmorty.models.RespList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface RickApi {

    @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
    @GET
    suspend fun buscarPersonagem(@Url url: String): Response<Personagem>

    @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
    @GET
    suspend fun buscarPersonagem1(
        @Url url: String,
        @Query("page") page: Int? = null
    ): RespList<Personagem>
}