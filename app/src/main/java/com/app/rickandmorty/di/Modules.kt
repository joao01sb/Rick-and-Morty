package com.app.rickandmorty.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.app.rickandmorty.data.remote.network.RickApi
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.dao.CharacterDAO
import com.app.rickandmorty.data.remote.CharacterRemoteMediator
import com.app.rickandmorty.ui.viewModel.CharacterDetailsViewModel
import com.app.rickandmorty.ui.viewModel.CharactersViewModel
import com.app.rickandmorty.ui.viewModel.FavoritesScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val connectionModule = module {
    factoryOf(::provideOkHttpClient)
    singleOf(::provideConnection)
}

val repositoryModule = module {
    single { Room.databaseBuilder(get(), AppDataBase::class.java, "characters.db").build() }
    single<CharacterDAO> { get<AppDataBase>().characterDAO() }
}

@OptIn(ExperimentalPagingApi::class)
val useCaseModule = module {
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
    viewModel { CharactersViewModel(get()) }
    viewModelOf(::FavoritesScreenViewModel)
    viewModel { CharacterDetailsViewModel(get()) }
}

fun provideConnection(okHttpClient: OkHttpClient): RickApi = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()
    .create(RickApi::class.java)

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}


val dataModules = listOf(connectionModule, repositoryModule, useCaseModule)

