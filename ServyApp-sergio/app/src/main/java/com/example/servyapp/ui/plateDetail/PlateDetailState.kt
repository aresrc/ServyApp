package com.example.servyapp.ui.plateDetail

import java.net.URL

data class PlateDetailState (
    val id: String = "",
    val restauranteId: String = "",
    val plato: String = "",
    val descripcion: String = "",
    val ingredientes: List<String> = emptyList(),
    val precio: Double = 0.0,
    val imagenURL: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)