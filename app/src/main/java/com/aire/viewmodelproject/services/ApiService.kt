package com.aire.viewmodelproject.services

import com.aire.viewmodelproject.data.Character
import com.aire.viewmodelproject.data.CharacterResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}