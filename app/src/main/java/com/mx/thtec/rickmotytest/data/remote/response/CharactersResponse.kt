package com.mx.thtec.rickmotytest.data.remote.response

import com.mx.thtec.rickmotytest.data.model.Personajes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponse(
    @Json(name = "results") val results: List<Personajes>
)
