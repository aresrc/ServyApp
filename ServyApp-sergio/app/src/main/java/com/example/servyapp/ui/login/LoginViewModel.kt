package com.example.servyapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servyapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState

    fun updateEmail(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updatePassword(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun mostrarEsconderPassword(){
        val valorActual = _uiState.value.mostrarPassword
        _uiState.update { it.copy(mostrarPassword = !valorActual) }
    }

    fun updateErrorMessage(newMessage: String){
        _uiState.update { it.copy(errorMessage = newMessage) }
    }

    fun mostrarMensajeError(){
        val valorActual = _uiState.value.mostrarMensajeError
        _uiState.update { it.copy(mostrarMensajeError = !valorActual) }
    }

    fun loginButtonPressed(){
        if(
            _uiState.value.email.isEmpty() ||
            _uiState.value.password.isEmpty()
        ){
            _uiState.update { it.copy(mostrarMensajeError = true) }
            _uiState.update { it.copy(errorMessage = "Por favor, complete todos los campos") }
        }else{
            viewModelScope.launch {
                try {
                    authRepository.logIn(_uiState.value.email, _uiState.value.password)
                    _uiState.update { it.copy(navigateToHome = true) }
                } catch (e: Exception) {
                    _uiState.update { it.copy(mostrarMensajeError = true) }
                    _uiState.update { it.copy(errorMessage = "Error al iniciar sesion: ${e.message.toString()}") }
                }
            }
        }
    }
}