package com.bina.binarickymorty.data.api

import com.bina.binarickymorty.data.api.RickAndMortyApi.PatchConstants.LISTCHARACTERS
import com.bina.binarickymorty.data.model.ListCharactersModel
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET(LISTCHARACTERS)

    suspend fun getListCharacters(): ListCharactersModel

    object PatchConstants {
        const val LISTCHARACTERS = "character"
    }
}