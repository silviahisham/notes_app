package com.silviahisham.notesapp.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun LocalDateTime.formatDate(): String {
    val formatter = DateTimeFormatter.ofPattern("EEE, d MMM hh:mm a", Locale.getDefault())
    return format(formatter)
}