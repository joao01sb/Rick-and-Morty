package com.app.rickandmorty.data.remote.network

import com.app.rickandmorty.data.remote.dto.CharacterDto
import com.app.rickandmorty.domain.models.RespList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.http.headers

class RickApiUseCase(
    private val client: HttpClient
) {
    suspend fun searchCharactersByPag(page: Int): ResultRequest<RespList<CharacterDto>> {
        return try {
            val response: RespList<CharacterDto> = client.get("character") {
                headers {
                    append(HttpHeaders.ContentType, "application/json; charset=UTF-8")
                    append(HttpHeaders.Accept, "application/json")
                }
                parameter("page", page)
            }.body()
            ResultRequest.Success(response)
        } catch (e: Exception) {
            ResultRequest.Error(e)
        }
    }

}