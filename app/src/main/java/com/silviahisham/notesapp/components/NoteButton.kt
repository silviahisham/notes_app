package com.silviahisham.notesapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClickAction: () -> Unit
) {
    Button(onClick = onClickAction, modifier = modifier, shape = CircleShape) {
        Text(text)
    }
}