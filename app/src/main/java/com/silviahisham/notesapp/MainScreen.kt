package com.silviahisham.notesapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.silviahisham.notesapp.components.AppBar
import com.silviahisham.notesapp.ui.theme.NotesAppTheme

@Composable
fun MainScreen() {
    Scaffold(topBar = { AppBar(title = stringResource(id = R.string.app_name)) }) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppTheme {
        MainScreen()
    }
}