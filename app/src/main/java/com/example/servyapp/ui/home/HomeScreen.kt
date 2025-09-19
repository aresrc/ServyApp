package com.example.servyapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column {
        Text(
            text = "Pagina principal"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Agregar todo lo que falta"
        )
    }
}