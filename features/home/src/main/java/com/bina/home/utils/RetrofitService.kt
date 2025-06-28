package com.bina.home.utils

import com.bina.home.data.api.CharactersApi
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://rickandmortyapi.com/api/"

class RetrofitService {
    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        @JvmStatic
        val service: CharactersApi by lazy {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofit.create(CharactersApi::class.java)
        }
    }
}