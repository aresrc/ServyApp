package com.example.servyapp.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.example.servyapp.data.repository.AuthRepository
import com.example.servyapp.domain.useCase.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignupState())
    val uiState: StateFlow<SignupState> = _uiState

    fun updateEmail(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updatePassword(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun updatePhone(newPhone: String) {
        _uiState.update { it.copy(phone = newPhone) }
    }

    fun mostrarEsconderPassword(){
        val valorActual = _uiState.value.mostrarPassword
        _uiState.update { it.copy(mostrarPassword = !valorActual) }
    }

    fun updateErrorMessage(newMessage: String){
        _uiState.update { it.copy(errorMessage = newMessage) }
    }

    fun registerButtonPressed(){
        when {
            _uiState.value.email.isEmpty() || _uiState.value.password.isEmpty() || _uiState.value.phone.isEmpty() -> {
                _uiState.update { it.copy(mostrarMensajeError = true) }
                _uiState.update { it.copy(errorMessage = "Por favor, complete todos los campos") }

                return
            }

            !uiState.value.email.contains("@") || !uiState.value.email.contains(".") -> {
                _uiState.update { it.copy(mostrarMensajeError = true) }
                _uiState.update { it.copy(errorMessage = "El email no es válido") }

                return
            }

            uiState.value.password.length < 6 -> {
                _uiState.update { it.copy(mostrarMensajeError = true) }
                _uiState.update { it.copy(errorMessage = "La contraseña debe tener al menos 6 caracteres") }

                return
            }

            _uiState.value.phone.length != 9 -> {
                _uiState.update { it.copy(mostrarMensajeError = true) }
                _uiState.update { it.copy(errorMessage = "El teléfono debe tener 9 dígitos") }

                return
            }
        }

        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            val result = signupUseCase.execute(uiState.value.email, uiState.value.password, uiState.value.phone)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    mostrarMensajeError = !result.isSuccess,
                    errorMessage = result.exceptionOrNull()?.message.toString(),
                    navigateToHome = result.isSuccess
                )
            }

        }
    }
}