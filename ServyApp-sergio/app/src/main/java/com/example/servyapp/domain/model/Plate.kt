package com.example.servyapp.domain.model

data class Plate(
    val id: String = "",
    val restauranteId: String = "",
    val plato: String = "",
    val descripcion: String = "",
    val ingredientes: List<String> = emptyList(),
    val precio: Double = 0.0,
    val imagenURL: String = ""
)
