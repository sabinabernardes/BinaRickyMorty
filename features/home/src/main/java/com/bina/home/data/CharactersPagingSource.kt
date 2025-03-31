package com.bina.home.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bina.home.data.api.CharactersApi
import com.bina.home.data.model.ListCharactersModel

class CharactersPagingSource(
    private val api: CharactersApi,
    private val query: String
) : PagingSource<Int, ListCharactersModel.Results>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListCharactersModel.Results> {
        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(
                page = page,
                limit = params.loadSize, // ou remove se a API não aceita
                query = query
            )

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ListCharactersModel.Results>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }
}

