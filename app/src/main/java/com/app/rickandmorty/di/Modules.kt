package com.app.rickandmorty.di

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.dao.CharacterDAO
import com.app.rickandmorty.data.remote.CharacterRemoteMediator
import com.app.rickandmorty.data.remote.network.RickApiUseCase
import com.app.rickandmorty.ui.viewModel.CharacterDetailsViewModel
import com.app.rickandmorty.ui.viewModel.CharactersViewModel
import com.app.rickandmorty.ui.viewModel.FavoritesScreenViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


val connectionModule = module {
    singleOf(::provideConnection)
}

val repositoryModule = module {
    single { Room.databaseBuilder(get(), AppDataBase::class.java, "characters.db").build() }
    single<CharacterDAO> { get<AppDataBase>().characterDAO() }
}

@OptIn(ExperimentalPagingApi::class)
val useCaseModule = module {
    singleOf(::RickApiUseCase)
    single {
        Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CharacterRemoteMediator(
                dataBase = get(),
                characterApi = get()
            ),
            pagingSourceFactory = {
                get<AppDataBase>().characterDAO().pagingSource()
            }
        )
    }
    viewModelOf(::CharactersViewModel)
    viewModelOf(::FavoritesScreenViewModel)
    viewModelOf(::CharacterDetailsViewModel)
}

fun provideConnection(): HttpClient {
    return HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("Logger Ktor =>", message)
                }

            }
            level = LogLevel.ALL
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "rickandmortyapi.com"
                encodedPath = "/api/"
            }
        }
    }
}

val dataModules = listOf(connectionModule, repositoryModule, useCaseModule)

