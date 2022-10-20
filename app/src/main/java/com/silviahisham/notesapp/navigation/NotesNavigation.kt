package com.silviahisham.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.silviahisham.notesapp.screens.notes.NotesScreen
import com.silviahisham.notesapp.screens.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun NotesNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.name) {
        composable(Routes.SplashScreen.name) {
            SplashScreen(navController)
        }
        composable(Routes.NotesScreen.name) {
            NotesScreen()
        }
    }
}