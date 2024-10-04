package com.example.newsappmvi.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.LoginInitialState)
    val loginState: StateFlow<LoginState> = _loginState


    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.PhoneNumberEvent -> {
                val phone = event.phoneNumber
                viewModelScope.launch {
                    if (phone.length != 10) {
                        _loginState.emit(LoginState.LoginErrorState(message = "Invalid Phone Number"))
                    } else {
                        _loginState.emit(LoginState.LoginLoadingState)
                    }
                }
            }
        }
    }
}




sealed class LoginState {
    data object LoginInitialState : LoginState()
    data object LoginLoadingState : LoginState()
    data class LoginErrorState(val message : String) : LoginState()
}

sealed class LoginEvent{
    data class PhoneNumberEvent(val phoneNumber : String) : LoginEvent()
}