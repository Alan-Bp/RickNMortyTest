package com.mx.thtec.rickmotytest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "characters")
data class Personajes(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String
)


@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val url: String
)