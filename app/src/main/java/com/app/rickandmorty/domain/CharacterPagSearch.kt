package com.app.rickandmorty.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.rickandmorty.domain.repository.SearchCharacterPag
import com.app.rickandmorty.domain.models.Character

class CharacterPagSearch(
    val getCharacters: SearchCharacterPag,
) : PagingSource<Int, Character>() {


    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Character> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getCharacters(nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? = state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

}