package com.mx.thtec.rickmotytest.presentation.ui.characterlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mx.thtec.rickmotytest.domain.model.CharacterDomain
import com.mx.thtec.rickmotytest.presentation.viewmodel.CharacterViewModel

@Composable
fun PersonajesListScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    onPersonajeClick: (Int) -> Unit
) {
    val personajes = viewModel.characters.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(personajes) { personaje ->
            PersonajeCard(personaje = personaje, onClick = { onPersonajeClick(personaje.id) })
        }
    }
}

@Composable
fun PersonajesListScreenPreview(
    onPersonajeClick: (Int) -> Unit = {}
) {
    val fakePersonajes = List(6) { index ->
        CharacterDomain(
            id = index + 1,
            name = "Character $index",
            status = "Alive",
            species = "Human",
            gender = "Male",
            origin = "Earth",
            location = "Unknown",
            image = "https://rickandmortyapi.com/api/character/avatar/$index.jpeg"
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(fakePersonajes) { personaje ->
            PersonajeCard(personaje = personaje, onClick = { onPersonajeClick(personaje.id) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonajesListScreen() {
    PersonajesListScreenPreview()
}