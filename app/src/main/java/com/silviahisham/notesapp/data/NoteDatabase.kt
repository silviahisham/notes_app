package com.silviahisham.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.silviahisham.notesapp.data.typeconverters.DateConverter
import com.silviahisham.notesapp.data.typeconverters.UUIDConverter
import com.silviahisham.notesapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}