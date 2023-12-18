package com.polstat.ukmesport.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polstat.ukmesport.auth.AuthHelper
import com.polstat.ukmesport.retrofit.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authHelper: AuthHelper
): ViewModel() {

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    private var _registeredName = MutableStateFlow("")
    val registeredName = _registeredName.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            authHelper.login(email, password).collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let { token ->
                            _token.value = token
                        }
                    }

                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                }
            }
        }
    }

    fun register(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            authHelper.register(name, email, password).collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let {  response ->
                            _registeredName.value = response.name
                        }
                    }

                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                }

            }
        }
    }
    fun changename(
        name: String,
    ){

    }
    fun changepassword(
        password: String,
    ){

    }
}
