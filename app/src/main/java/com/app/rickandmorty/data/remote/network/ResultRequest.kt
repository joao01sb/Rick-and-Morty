package com.app.rickandmorty.data.remote.network

sealed class ResultRequest<out T> {
    data class Success<out T>(val data: T) : ResultRequest<T>()
    data class Error(val exception: Exception) : ResultRequest<Nothing>()
}
