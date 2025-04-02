package com.mx.thtec.rickmotytest.data.model

import com.mx.thtec.rickmotytest.domain.model.CharacterDomain

fun Personajes.toDomain(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = origin.name,
        location = location,
        image = image
    )
}