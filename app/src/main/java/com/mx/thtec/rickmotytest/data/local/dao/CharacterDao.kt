package com.mx.thtec.rickmotytest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mx.thtec.rickmotytest.data.model.Personajes

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<Personajes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(personajes: List<Personajes>)
}
