package com.polstat.ukmesport.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polstat.ukmesport.retrofit.Result
import com.polstat.ukmesport.auth.AuthHelper
import com.polstat.ukmesport.auth.MainHelper
import com.polstat.ukmesport.auth.ProfileResponse
import com.polstat.ukmesport.auth.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainHelper: MainHelper
): ViewModel() {


    private val _profile = MutableStateFlow(ProfileResponse("",""))
    var profile = _profile.asStateFlow()
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    fun profile(

    ) {
        viewModelScope.launch {
            mainHelper.profile("Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQGdtYWlsLmNvbSIsImlhdCI6MTcwMjgzNzcxMywiZXhwIjoxNzAyOTI0MTEzfQ.BAmhvx5ThDRqzR9BgJUBgFV7TPMaVeEQPL_Bfo3sknQ").collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let { result ->
                            _profile.value = result

                        }
                        }

                        is Result.Error -> {
                            _showErrorToastChannel.send(true)
                        }

                    }
                }

            }

        }

    }
    fun EditProfil(
        name: String,
        password: String
){

    }
