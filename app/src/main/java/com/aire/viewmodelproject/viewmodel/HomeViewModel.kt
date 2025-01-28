package com.aire.viewmodelproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aire.viewmodelproject.data.Character
import com.aire.viewmodelproject.data.CharacterResponse
import com.aire.viewmodelproject.di.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _characters = MutableStateFlow<CharacterResponse>(CharacterResponse())
    val characters: StateFlow<CharacterResponse> = _characters

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchCharacter()
    }

    private fun fetchCharacter() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val fetchedCharacters = RetrofitInstance.api.getCharacters()
                _characters.value = fetchedCharacters
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

}