package com.silviahisham.notesapp.screens.notes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.silviahisham.notesapp.R
import com.silviahisham.notesapp.components.AppBar
import com.silviahisham.notesapp.components.NoteButton
import com.silviahisham.notesapp.components.NotesTextField
import com.silviahisham.notesapp.model.Note
import com.silviahisham.notesapp.ui.theme.NotesAppTheme
import com.silviahisham.notesapp.ui.theme.TealLight
import com.silviahisham.notesapp.utils.formatDate

@ExperimentalComposeUiApi
@Composable
fun NotesScreen() {
    val viewModel = hiltViewModel<NotesViewModel>()
    val notesList = viewModel.getNotes().collectAsState().value
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var titleState by remember {
        mutableStateOf("")
    }
    var descriptionState by remember {
        mutableStateOf("")
    }

    Scaffold(topBar = { AppBar(title = stringResource(id = R.string.app_name)) }) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                NotesTextField(
                    value = titleState,
                    label = stringResource(id = R.string.note_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onValueChange = {
                        titleState = it
                    }
                )
                NotesTextField(
                    value = descriptionState,
                    label = stringResource(id = R.string.note_body),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    maxLines = 20,
                    onValueChange = {
                        descriptionState = it
                    }
                )

                NoteButton(text = stringResource(id = R.string.action_save)) {
                    if (titleState.isNotEmpty() && descriptionState.isNotEmpty()) {
                        viewModel.addNote(Note(title = titleState, description = descriptionState))
                        Toast.makeText(context, R.string.toast_note_saved, Toast.LENGTH_SHORT).show()

                        titleState = ""
                        descriptionState = ""

                        keyboardController?.hide()
                    }
                }

                Divider(modifier = Modifier.padding(8.dp))

                LazyColumn {
                    items(notesList) { note ->
                        NoteItem(note = note)
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = TealLight,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(text = note.date.formatDate(), style = MaterialTheme.typography.caption)
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppTheme {
        NotesScreen()
    }
}