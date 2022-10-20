package com.silviahisham.notesapp.data.typeconverters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun dateFromTimeStamp(timeStamp: Long): Date = Date(timeStamp)

    @TypeConverter
    fun timeStampFromDate(date: Date): Long = date.time
}