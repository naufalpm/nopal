package com.polstat.ukmesport.auth

import com.polstat.ukmesport.retrofit.Result
import kotlinx.coroutines.flow.Flow

interface MainHelper {
    suspend fun profile(bearer:String): Flow<Result<ProfileResponse>>

}