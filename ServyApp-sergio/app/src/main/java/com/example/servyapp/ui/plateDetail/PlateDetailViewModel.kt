package com.example.servyapp.ui.plateDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servyapp.data.repository.AuthRepository
import com.example.servyapp.data.repository.PlateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlateDetailViewModel @Inject constructor(
    private val plateRepository: PlateRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlateDetailState())
    val uiState: StateFlow<PlateDetailState> = _uiState

    fun loadPlate(restaurantId: String, plateId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = plateRepository.getPlateById(restaurantId, plateId)

            _uiState.update {
                if (result.isSuccess && result.getOrNull() != null) {
                    val plate = result.getOrNull()!!
                    it.copy(
                        id = plate.id,
                        restauranteId = plate.restauranteId,
                        plato = plate.plato,
                        descripcion = plate.descripcion,
                        ingredientes = plate.ingredientes,
                        precio = plate.precio,
                        imagenURL = plate.imagenURL,
                        isLoading = false,
                        errorMessage = null
                    )
                } else {
                    it.copy(
                        isLoading = false,
                        errorMessage = result.exceptionOrNull()?.message ?: "No se encontró el plato"
                    )
                }
            }
        }
    }
}