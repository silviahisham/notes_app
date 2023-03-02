package com.silviahisham.notesapp.data

import com.silviahisham.notesapp.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val ioContext: CoroutineContext,
) {
    fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun getNoteById(id: String): Note = withContext(ioContext) {
        noteDao.getNoteById(id)
    }

    suspend fun addNote(note: Note) = withContext(ioContext) {
        noteDao.addNote(note)
    }

    suspend fun deleteNote(note: Note) = withContext(ioContext) {
        noteDao.deleteNote(note)
    }
}