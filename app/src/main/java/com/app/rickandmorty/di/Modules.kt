package com.app.rickandmorty.di

import androidx.room.Room
import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.data.AppDataBase
import com.app.rickandmorty.data.PersonagemRepositoryImpl
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.domain.CharacterPagingSource
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.GetPersonagemByPag
import com.app.rickandmorty.domain.repository.PersonagemBanco
import com.app.rickandmorty.domain.repository.PersonagemRepository
import com.app.rickandmorty.domain.repository.PersonagensRepository1
import com.app.rickandmorty.domain.viewModel.ListaDePersonagensViewModel
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel
import com.app.rickandmorty.domain.viewModel.PersonagemViewModel2
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




//val appDados = module {
//
//    single<PersonagensRepository1> {
//        PersonagensRepository1(get())
//    }
//    viewModel { ListaDePersonagensViewModel(get(), get()) }
//}

val connection = module {
    factory { provideOkHttpClient() }

    single { provideConnection(get()) }
}

val repositoryModule = module {

    factory { PersonagemRepositoryImpl(get()) } bind PersonagemRepository::class

    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "personagens.db"
        ).build()
    }

    single<PersonagemDAO> { get<AppDataBase>().PersonagemAcoes() }

    single<PersonagemBanco> { PersonagemBanco(get()) }
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
        GetPersonagemByPag(
            coroutineContext = get(),
            repository = get()
        )
    }
}

val domainModules = listOf(useCaseModule)

val presentationModule = module {

    factory { CharacterPagingSource(get())  }

    viewModel {
        ListaDePersonagensViewModel(get(), get(), get())
    }
    viewModel {
        PersonagemViewModel2(get())
    }
    viewModel { (c: Personagem) -> PersonagemViewModel(c) }

}

val presentationModules = listOf(presentationModule)

