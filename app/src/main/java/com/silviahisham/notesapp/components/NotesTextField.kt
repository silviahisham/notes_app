package com.silviahisham.notesapp.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NotesTextField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        label = { Text(text = label) },
        onValueChange = onValueChange,
        maxLines = maxLines,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
    )
}