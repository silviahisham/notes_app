package com.silviahisham.notesapp.screens.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silviahisham.notesapp.model.Note
import com.silviahisham.notesapp.ui.theme.TealDark
import com.silviahisham.notesapp.ui.theme.TealLight
import com.silviahisham.notesapp.utils.formatDate

@Composable
fun NoteItem(note: Note, onDeleteClick: () -> Unit = {}) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = TealLight,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = note.title, style = MaterialTheme.typography.subtitle2)
                Text(text = note.description, style = MaterialTheme.typography.subtitle1)
                Text(text = note.date.formatDate(), style = MaterialTheme.typography.caption)
            }
            IconButton(
                onClick = onDeleteClick,
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    tint = TealDark,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun NoteItemPreview() {
    NoteItem(
        note = Note(
            title = "Test note",
            description = "Test Description"
        )
    )
}