package com.polstat.ukmesport.auth


import com.polstat.ukmesport.retrofit.Result
import com.polstat.ukmesport.retrofit.Token
import kotlinx.coroutines.flow.Flow

interface AuthHelper {
    suspend fun login(email: String, password: String): Flow<Result<Token>>

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): Flow<Result<RegisterResponse>>
}
