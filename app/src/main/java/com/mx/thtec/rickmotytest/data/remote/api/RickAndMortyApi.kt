package com.mx.thtec.rickmotytest.data.remote.api

import com.mx.thtec.rickmotytest.data.model.Personajes
import com.mx.thtec.rickmotytest.data.remote.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Personajes
}
