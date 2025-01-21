package com.aire.viewmodelproject.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _nombre = MutableStateFlow<String>("")
    val nombre = _nombre.asStateFlow()

    fun onValueChanged(name : String){
        _nombre.value = name
    }

}