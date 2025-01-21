package com.aire.viewmodelproject.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _enabled = MutableStateFlow(false)
    val enabled = _enabled.asStateFlow()

   fun onValueChanged(name : String, password : String){
       _userName.value = name
       _password.value = password
       _enabled.value = isCorrect()
   }

    fun isCorrect() = _userName.value.isNotEmpty() && _password.value.isNotEmpty()

    fun onNavigate(){

    }

}