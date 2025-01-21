package com.aire.viewmodelproject.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.aire.viewmodelproject.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()){

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        val nombre by homeViewModel.nombre.collectAsState()

        TextField(value = nombre, onValueChange = {
            homeViewModel.onValueChanged(it)
        })
    }

}