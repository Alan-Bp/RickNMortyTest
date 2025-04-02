package com.mx.thtec.rickmotytest.presentation.ui.characterdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mx.thtec.rickmotytest.R
import com.mx.thtec.rickmotytest.presentation.viewmodel.CharacterViewModel


@Composable
fun PersonajeDetailScreen(
    personajeId: Int,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    LaunchedEffect(personajeId) {
        viewModel.fetchCharacterById(personajeId)
    }
    val personaje = viewModel.selectedCharacter.collectAsState().value

    personaje?.let {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.th_blue))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(color = colorResource(id = R.color.th_gold))
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Nombre: ${it.name}")
                    Text(text = "Estado: ${it.status}")
                    Text(text = "Especie: ${it.species}")
                    Text(text = "Género: ${it.gender}")
                    Text(text = "Origen: ${it.origin}")
                    Text(text = "Ubicación: ${it.location}")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPersonajeDetailScreen() {
    PersonajeDetailScreen(
        personajeId = 1,
        viewModel = viewModel()
    )
}