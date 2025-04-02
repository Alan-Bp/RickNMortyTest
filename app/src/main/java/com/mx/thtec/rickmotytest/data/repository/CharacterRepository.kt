package com.mx.thtec.rickmotytest.data.repository

import android.util.Log
import com.mx.thtec.rickmotytest.data.local.dao.CharacterDao
import com.mx.thtec.rickmotytest.data.model.toDomain
import com.mx.thtec.rickmotytest.data.remote.api.RickAndMortyApi
import com.mx.thtec.rickmotytest.domain.model.CharacterDomain
import javax.inject.Inject


class CharacterRepository @Inject constructor(
    private val api: RickAndMortyApi,
    private val characterDao: CharacterDao
) {
    companion object {
        private const val TAG = "CharacterRepository"
    }

    suspend fun getCharacters(): List<CharacterDomain> {
        val response = api.getAllCharacters()
        val characters = response.results
        return try {
            Log.d(TAG, "Obtenidos ${characters.size} personajes desde API")
            characterDao.insertAll(characters)
            Log.d(TAG, "Guardados en BD local")
            characters.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e(TAG, "Error en API: ${e.message}")
            val local = characterDao.getAllCharacters()
            Log.d(TAG, "Recuperados ${local.size} desde BD local")
            characters.map { it.toDomain() }
        }
    }

    suspend fun getCharacterById(id: Int): CharacterDomain {
        return try {
            val character = api.getCharacterById(id)
            Log.d(TAG, "Obtenido personaje id $id desde API")
            characterDao.insertAll(listOf(character))
            Log.d(TAG, "Guardado en BD local")
            character.toDomain()
        } catch (e: Exception) {
            Log.e(TAG, "Error en API para id $id: ${e.message}")
            characterDao.getAllCharacters().firstOrNull { it.id == id }?.toDomain()
                ?: throw e
        }
    }
}