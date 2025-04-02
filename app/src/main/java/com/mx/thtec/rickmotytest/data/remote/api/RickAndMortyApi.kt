package com.mx.thtec.rickmotytest.data.remote.api

import com.mx.thtec.rickmotytest.data.model.Personajes
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(): List<Personajes>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Personajes
}