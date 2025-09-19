package com.example.servyapp.ui.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val mostrarPassword: Boolean = false,
    val errorMessage: String = "",
    val mostrarMensajeError: Boolean = false,
    val navigateToHome: Boolean = false
)