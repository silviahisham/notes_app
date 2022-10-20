package com.silviahisham.notesapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silviahisham.notesapp.data.NoteRepository
import com.silviahisham.notesapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val notesList = MutableStateFlow<List<Note>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().collect { notes ->
                notesList.value = notes
            }
        }
    }

    fun getNotes() = notesList.asStateFlow()

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }
    }
}