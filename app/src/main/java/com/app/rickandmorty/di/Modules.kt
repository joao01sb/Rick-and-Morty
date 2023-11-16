package com.app.rickandmorty.di

import androidx.room.Room
import com.app.rickandmorty.data.remote.network.RickApi
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.dao.CharcterDAO
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.ui.viewModel.CharacterViewModel
import com.app.rickandmorty.domain.models.Character
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val connectionModule = module {
    factory { provideOkHttpClient() }

    single { provideConnection(get()) }
}

val repositoryModule = module {


    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "personagens.db"
        ).build()
    }

    single<CharcterDAO> { get<AppDataBase>().charactersActionData() }

}

val dataModules = listOf(connectionModule, repositoryModule)


fun provideConnection(okHttpClient: OkHttpClient): RickApi = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()
    .create(RickApi::class.java)

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}


val useCaseModule = module {
    single { CoroutineContext(Dispatchers.Main, Dispatchers.IO) }

}

val domainModules = listOf(useCaseModule)

val presentationModule = module {


}

val presentationModules = listOf(presentationModule)

