package com.polstat.ukmesport.retrofit

import com.polstat.ukmesport.auth.RegisterResponse
import com.polstat.ukmesport.auth.LoginResponse
import com.polstat.ukmesport.auth.LoginRequest
import com.polstat.ukmesport.auth.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

typealias Token = String

interface AuthApi {

    @POST("auth/signin")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/signup")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse
}
