package com.silviahisham.notesapp.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.silviahisham.notesapp.ui.theme.AppBarColor

@Composable
fun AppBar(title: String) {
    TopAppBar(title = { Text(text = title) }, backgroundColor = AppBarColor)
}