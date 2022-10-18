package com.silviahisham.notesapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.silviahisham.notesapp.model.Note

class NotesViewModel : ViewModel() {
    private val notesList = mutableStateListOf<Note>()

    fun getNotes(): List<Note> = notesList

    fun addNote(note: Note) {
        notesList.add(note)
    }
}