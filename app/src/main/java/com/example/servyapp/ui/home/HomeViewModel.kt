package com.example.servyapp.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState

    fun onExpandedChange(){
//        val valorActual = _uiState.value.expanded
//        _uiState.update { it.copy(expanded = !valorActual) }
    }

    fun getAllPlates(){
        //_uiState.update { it.copy(plates = getPlates()) }
    }

    init {
        getAllPlates()
    }
}