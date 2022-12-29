package com.app.rickandmorty.di

import androidx.room.Room
import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.data.AppDataBase
import com.app.rickandmorty.domain.repository.PersonagemRepository
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.domain.PersonagemPagProcura
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.BuscarPersonagemPorPag
import com.app.rickandmorty.domain.viewModel.PersonagensViewModel
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val connection = module {
    factory { provideOkHttpClient() }

    single { provideConnection(get()) }
}

val repositoryModule = module {

    factory { PersonagemRepository(get(), get()) }

    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "personagens.db"
        ).build()
    }

    single<PersonagemDAO> { get<AppDataBase>().PersonagemAcoes() }

}

val dataModules = listOf(connection, repositoryModule)

fun provideConnection(okHttpClient: OkHttpClient): RickApi = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(provideOkHttpClient())
    .build()
    .create(RickApi::class.java)

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}

val useCaseModule = module {
    single { CoroutineContext(Dispatchers.Main, Dispatchers.IO) }
    factory {
        BuscarPersonagemPorPag(
            coroutineContext = get(),
            repository = get()
        )
    }
}

val domainModules = listOf(useCaseModule)

val presentationModule = module {

    factory { PersonagemPagProcura(get())  }

    viewModel { PersonagensViewModel(get(), get(), get(), get()) }
    viewModel { (p: Personagem) -> PersonagemViewModel(p, get()) }

}

val presentationModules = listOf(presentationModule)

