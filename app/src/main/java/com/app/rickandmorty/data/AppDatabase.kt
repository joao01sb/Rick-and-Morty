package com.app.rickandmorty.data

//@Database(entities = [Personagem::class, Usuario::class], version = 1, exportSchema = true)
//
//abstract class AppDataBase : RoomDatabase() {
//
//    abstract fun buscarPersonagemFavorito(): PersonagemDAO
//
//    companion object {
//        fun instancia(context: Context): AppDataBase = Room.databaseBuilder(
//            context,
//            AppDataBase::class.java,
//            "rickapp.db"
//        ).build()
//    }
//
//}