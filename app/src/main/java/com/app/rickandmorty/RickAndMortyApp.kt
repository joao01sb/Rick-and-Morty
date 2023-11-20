package com.app.rickandmorty

import android.app.Application
import com.app.rickandmorty.di.dataModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApp)
            modules(dataModules)
        }
    }
}