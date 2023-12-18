package com.polstat.ukmesport.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polstat.ukmesport.retrofit.Result
import com.polstat.ukmesport.auth.AuthHelper
import com.polstat.ukmesport.auth.MainHelper
import com.polstat.ukmesport.auth.ProfileResponse
import com.polstat.ukmesport.auth.Session
import com.polstat.ukmesport.auth.SessionCache
import com.polstat.ukmesport.auth.User
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
    private val mainHelper: MainHelper,
    private val sessionCache: SessionCache
): ViewModel() {

    val profile: User = sessionCache.getActiveSession()?.user!!
    val token: String = sessionCache.getActiveSession()?.token!!

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

//    fun EditProfil(
//        name: String,
//        password: String
//    ) {
//
//    }
}