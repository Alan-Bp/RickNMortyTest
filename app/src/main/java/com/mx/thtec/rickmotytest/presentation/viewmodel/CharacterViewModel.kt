package com.mx.thtec.rickmotytest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.thtec.rickmotytest.data.repository.CharacterRepository
import com.mx.thtec.rickmotytest.domain.model.CharacterDomain
import com.squareup.moshi.JsonDataException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    companion object {
        private const val TAG = "CharacterViewModel"
    }

    private val _characters = MutableStateFlow<List<CharacterDomain>>(emptyList())
    val characters: StateFlow<List<CharacterDomain>> = _characters

    private val _selectedCharacter = MutableStateFlow<CharacterDomain?>(null)
    val selectedCharacter: StateFlow<CharacterDomain?> = _selectedCharacter

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Cargando personajes...")
                val list = repository.getCharacters()
                _characters.value = list
                Log.d(TAG, "Cargados ${list.size} personajes")
            } catch (e: IOException) {
                Log.e(TAG, "Error de red al cargar personajes: ${e.message}")
            } catch (e: HttpException) {
                Log.e(TAG, "Error HTTP ${e.code()} al cargar personajes: ${e.message()}")
            } catch (e: JsonDataException) {
                Log.e(TAG, "Error de parsing al cargar personajes: ${e.message}")
            }
        }
    }

    fun fetchCharacterById(id: Int) {
        viewModelScope.launch {
            try {
                Log.d(TAG, "Cargando detalle para id: $id")
                _selectedCharacter.value = repository.getCharacterById(id)
                Log.d(TAG, "Detalle cargado para id: $id")
            } catch (e: IOException) {
                Log.e(TAG, "Error de red al cargar detalle id $id: ${e.message}")
            } catch (e: HttpException) {
                Log.e(TAG, "Error HTTP ${e.code()} al cargar detalle id $id: ${e.message()}")
            } catch (e: JsonDataException) {
                Log.e(TAG, "Error de parsing detalle id $id: ${e.message}")
            }
        }
    }
}
