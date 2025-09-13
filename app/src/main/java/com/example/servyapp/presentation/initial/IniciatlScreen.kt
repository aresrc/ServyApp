package com.example.servyapp.presentation.initial

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.servyapp.R

@Composable
fun InitialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la aplicación"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "ServyApp",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
                // TODO: Aquí se agrega la lógica de navegación a la pantalla de inicio de sesión
            },
            modifier = Modifier.height(56.dp)
        ) {
            Text(text = "Iniciar sesión", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // TODO: Aquí se agrega la lógica de navegación a la pantalla de registro
            },
            modifier = Modifier.height(56.dp)
        ) {
            Text(text = "Registrarse", fontSize = 18.sp)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun InitialScreenPreview() {
    InitialScreen()
}