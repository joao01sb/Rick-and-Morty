package com.app.rickandmorty.extras

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.rickandmorty.R

fun ImageView.pegarImagemDoPersonagem(link: String) {
    load(link) {
        placeholder(R.drawable.ic_launcher_foreground)
    }
}

fun Context.abrirNovaTela(tela: Class<*>) {
    Intent(this, tela).apply {
        startActivity(this)
    }
}

fun <T : RecyclerView.ViewHolder> T.listenClick(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(getAdapterPosition(), getItemViewType())
    }
    return this
}