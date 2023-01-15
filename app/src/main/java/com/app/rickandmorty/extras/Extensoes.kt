package com.app.rickandmorty.extras

import android.widget.ImageView
import coil.load
import com.app.rickandmorty.R

fun ImageView.loadImage(link: String) {
    load(link) {
        placeholder(R.drawable.ic_launcher_foreground)
    }
}
