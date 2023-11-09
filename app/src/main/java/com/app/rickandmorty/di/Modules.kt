package com.app.rickandmorty.di

import androidx.room.Room
import com.app.rickandmorty.data.network.RickApi
import com.app.rickandmorty.data.AppDataBase
import com.app.rickandmorty.domain.repository.CharacterRepository
import com.app.rickandmorty.data.dao.CharcterDAO
import com.app.rickandmorty.domain.CharacterPagSearch
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.SearchCharacterPag
import com.app.rickandmorty.ui.viewModel.CharactersViewModel
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

    factory { CharacterRepository(get(), get()) }

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
    factory {
        SearchCharacterPag(
            coroutineContext = get(),
            repository = get()
        )
    }
}

val domainModules = listOf(useCaseModule)

val presentationModule = module {

    factory { CharacterPagSearch(get())  }

    viewModel { CharactersViewModel(get(), get(), get(), get()) }
    viewModel { (p: Character) -> CharacterViewModel(p, get()) }

}

val presentationModules = listOf(presentationModule)

