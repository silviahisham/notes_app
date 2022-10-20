package com.silviahisham.notesapp.data

import com.silviahisham.notesapp.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun getNoteById(id: String): Note = noteDao.getNoteById(id)

    suspend fun addNote(note: Note) = noteDao.addNote(note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}