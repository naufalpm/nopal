package com.polstat.ukmesport.retrofit

import com.polstat.ukmesport.auth.ProfileResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH


interface MainApi {

    @GET("test/profile")
    suspend fun profile(@Header("Authorization") bearerToken: Token): ProfileResponse

    @PATCH("test/profile")
    suspend fun updateProfile(@Header("Authorization") bearerToken: Token): ProfileResponse

}