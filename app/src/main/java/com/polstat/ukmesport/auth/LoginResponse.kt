package com.polstat.ukmesport.auth

import androidx.compose.ui.semantics.Role
import com.polstat.ukmesport.retrofit.Token

data class LoginResponse(
    val name: String,
    val email: String,
    val token: Token,
    val roles: String
)

