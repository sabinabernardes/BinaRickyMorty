package com.bina.home.data.api

import com.bina.home.data.api.RickAndMortyApi.PatchConstants.LISTCHARACTERS
import com.bina.home.data.model.ListCharactersModel
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET(LISTCHARACTERS)

    suspend fun getListCharacters(): ListCharactersModel

    object PatchConstants {
        const val LISTCHARACTERS = "character"
    }
}