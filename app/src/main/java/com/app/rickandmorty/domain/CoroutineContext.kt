package com.app.rickandmorty.domain

import kotlin.coroutines.CoroutineContext

class CoroutineContext(
    val Main: CoroutineContext,
    val IO: CoroutineContext
)