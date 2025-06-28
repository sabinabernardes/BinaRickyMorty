package com.bina.details.data.api

import com.bina.details.data.response.CharacterDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<CharacterDetailsResponse>
}