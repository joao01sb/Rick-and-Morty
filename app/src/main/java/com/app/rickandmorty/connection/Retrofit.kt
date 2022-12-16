package com.app.rickandmorty.connection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideConnection() : RickApi = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().build())
    .build()
    .create(RickApi::class.java)