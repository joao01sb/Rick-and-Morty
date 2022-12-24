package com.app.rickandmorty

import android.app.Application
import com.app.rickandmorty.di.dataModules
import com.app.rickandmorty.di.domainModules
import com.app.rickandmorty.di.presentationModule
import com.app.rickandmorty.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApp)
            modules(dataModules + domainModules + presentationModules)
        }
    }
}