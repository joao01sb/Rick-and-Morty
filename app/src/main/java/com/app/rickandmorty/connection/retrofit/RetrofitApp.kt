package com.app.rickandmorty.connection.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApp {

    private val retrofitConexao: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(create())
        .build()

    private fun create() : OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    fun <T> servico(classServico: Class<T>) : T {
        return retrofitConexao.create(classServico)
    }

}