package com.example.servyapp.ui.profile

import androidx.lifecycle.ViewModel
import com.example.servyapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileState(
        email = authRepository.currentUser?.email ?: ""
    ))
    val uiState: StateFlow<ProfileState> = _uiState

    fun logout(){
        authRepository.logout()
    }
}