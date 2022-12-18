package com.app.rickandmorty.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.rickandmorty.domain.repository.GetPersonagemByPag
import com.app.rickandmorty.models.Personagem

class CharacterPagingSource(
    val getCharacters: GetPersonagemByPag,
) : PagingSource<Int, Personagem>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Personagem> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = getCharacters(nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber+1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Personagem>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}