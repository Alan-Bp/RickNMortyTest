package com.mx.thtec.rickmotytest.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mx.thtec.rickmotytest.presentation.ui.characterdetail.PersonajeDetailScreen
import com.mx.thtec.rickmotytest.presentation.ui.characterlist.PersonajesListScreen
import com.mx.thtec.rickmotytest.util.Constants


@Composable
fun AppNavGraph(startDestination: String = "personajesList") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("personajesList") {
            PersonajesListScreen(
                onPersonajeClick = { id ->
                    navController.navigate("personajeDetail/$id")
                }
            )
        }
        composable(
            Constants.PERSONAJE_URL,
            arguments = listOf(navArgument("personajeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val personajeId = backStackEntry.arguments?.getInt("personajeId") ?: 0
            PersonajeDetailScreen(personajeId = personajeId)
        }
    }
}
