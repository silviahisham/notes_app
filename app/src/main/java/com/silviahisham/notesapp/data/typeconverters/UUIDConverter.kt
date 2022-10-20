package com.silviahisham.notesapp.data.typeconverters

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun uuidFromString(string: String): UUID = UUID.fromString(string)

    @TypeConverter
    fun stringFromUUID(uuid: UUID): String = uuid.toString()
}