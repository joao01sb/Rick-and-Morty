package com.app.rickandmorty.data.dao

import androidx.room.Insert
import androidx.room.Query
import com.app.rickandmorty.models.Usuario

interface UsuarioDAO {

    @Insert
    suspend fun salvarUsuario(vararg user: Usuario)

    @Query("select * from Usuario where nome = :nome and senha = :senha")
    suspend fun buscarUsuario(nome: String, senha: String): Usuario
}