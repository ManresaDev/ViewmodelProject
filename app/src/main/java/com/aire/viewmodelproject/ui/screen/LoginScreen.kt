package com.aire.viewmodelproject.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aire.viewmodelproject.viewmodel.LoginViewModel
import kotlin.math.log

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel()){
    val userName by loginViewModel.userName.collectAsState()
    val password by loginViewModel.password.collectAsState()
    val enabled by loginViewModel.enabled.collectAsState()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
       TextField(value = userName , onValueChange ={
           loginViewModel.onValueChanged(name = it, password = password)
       } )

        Spacer(modifier = Modifier.height(20.dp))

       TextField(value = password, onValueChange = {
           loginViewModel.onValueChanged(name = userName, password = it)
       })

        Spacer(modifier = Modifier.height(20.dp))

       Button(enabled = enabled,onClick = { loginViewModel.onNavigate() }) {
           Text(text = "Iniciar sesión")

       }
    }
}