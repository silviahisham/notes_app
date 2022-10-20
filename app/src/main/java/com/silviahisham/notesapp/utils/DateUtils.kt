package com.silviahisham.notesapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatDate(): String {
    val formatter = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return formatter.format(this)
}