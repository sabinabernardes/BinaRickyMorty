package com.bina.home.data.api

import com.bina.home.data.model.ListCharactersModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 50,
        @Query("name") query: String? = null
    ): ListCharactersModel
}