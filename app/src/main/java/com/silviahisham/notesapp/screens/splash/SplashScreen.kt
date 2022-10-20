package com.silviahisham.notesapp.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.silviahisham.notesapp.R
import com.silviahisham.notesapp.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController?) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.app_name))
        }
    }

    LaunchedEffect(key1 = true, block = {
        delay(2000)
        navController?.navigate(Routes.NotesScreen.name){
            popUpTo(Routes.SplashScreen.name){
                inclusive = true
            }
        }
    })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen(null)
}
